package dev.rodrigomuller.service.auth;

import dev.rodrigomuller.DTO.request.UserRegisterRequestDTO;
import dev.rodrigomuller.DTO.response.UserRegisterResponseDTO;
import dev.rodrigomuller.DTO.restclient.*;
import dev.rodrigomuller.entity.Customer;
import dev.rodrigomuller.exception.KeycloakRoleNotFoundException;
import dev.rodrigomuller.exception.KeycloakUserNotFoundException;
import dev.rodrigomuller.repository.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.Arrays;
import java.util.Set;

@ApplicationScoped
public class KeycloakAuthService implements AuthService {

    private static final Logger LOG = Logger.getLogger(KeycloakAuthService.class);

    KeycloakRESTAdminService keycloakRESTAdminService;

    CustomerRepository customerRepository;

    public KeycloakAuthService(
            CustomerRepository customerRepository,
            @RestClient
            KeycloakRESTAdminService keycloakRESTAdminService
    ) {
        this.customerRepository = customerRepository;
        this.keycloakRESTAdminService = keycloakRESTAdminService;
    }

    private AdminRealmResponseDTO adminRealmResponseDTO;

    @ConfigProperty(name = "share-a-tool.keycloak.admin.username")
    String adminUsername;

    @ConfigProperty(name = "share-a-tool.keycloak.admin.password")
    String adminPassword;

    @ConfigProperty(name = "share-a-tool.keycloak.users.realm")
    String usersRealm;

    Set<String> roles = Set.of("user");

    @Transactional
    public UserRegisterResponseDTO register(UserRegisterRequestDTO userRegisterRequestDTO) {
        boolean isUserCreatedInKeycloak = false;
        try {
            this.getAdminRealmToken();
            this.createUserInKeycloak(userRegisterRequestDTO);
            isUserCreatedInKeycloak = true;
            UserResponseDTO userResponseDTO = this.getUserByUsername(userRegisterRequestDTO.getUsername());
            RoleResponseDTO role = this.getRoleByName(roles.iterator().next());
            this.syncUserRealm(userResponseDTO.getId(), role);

            this.saveInDatabase(userRegisterRequestDTO, userResponseDTO.getId());

            UserRegisterResponseDTO userRegisterResponseDTO = new UserRegisterResponseDTO();
            userRegisterResponseDTO.setId(userResponseDTO.getId());
            userRegisterResponseDTO.setName(userResponseDTO.getFirstName());
            userRegisterResponseDTO.setSurname(userResponseDTO.getLastName());
            userRegisterResponseDTO.setEmail(userResponseDTO.getEmail());
            userRegisterResponseDTO.setRole(this.roles.iterator().next());

            return userRegisterResponseDTO;
        } catch (Exception e) {
            if (isUserCreatedInKeycloak) {
                this.rollbackUserCreationInKeycloak(userRegisterRequestDTO);
            }
            throw e;
        }
    }

    private void createUserInKeycloak(UserRegisterRequestDTO userRegisterRequestDTO) {
        CreateUserRequestDTO createUserRequestDTO = new CreateUserRequestDTO();
        createUserRequestDTO.setUsername(userRegisterRequestDTO.getUsername());
        createUserRequestDTO.setEmail(userRegisterRequestDTO.getEmail());
        createUserRequestDTO.setFirstName(userRegisterRequestDTO.getName());
        createUserRequestDTO.setLastName(userRegisterRequestDTO.getSurname());
        createUserRequestDTO.setEnabled(true);
        createUserRequestDTO.setRealmRoles(this.roles);
        Set<KeycloakCredentials> credentials = Set.of(new KeycloakCredentials("password", userRegisterRequestDTO.getPassword()));
        createUserRequestDTO.setCredentials(credentials);

        LOG.info("Creating user in keycloak");
        String bearerToken = "Bearer " + this.adminRealmResponseDTO.getAccess_token();
        this.keycloakRESTAdminService.createUser(bearerToken, usersRealm, createUserRequestDTO);
        LOG.info("User created in keycloak");
    }

    private void rollbackUserCreationInKeycloak(UserRegisterRequestDTO userRegisterRequestDTO) {
        LOG.info("Rolling back user creation in keycloak");
        String bearerToken = "Bearer " + this.adminRealmResponseDTO.getAccess_token();
        UserResponseDTO userResponseDTO = this.getUserByUsername(userRegisterRequestDTO.getUsername());
        this.keycloakRESTAdminService.deleteUser(bearerToken, usersRealm, userResponseDTO.getId());
        LOG.info("User creation rolled back in keycloak");
    }

    public Customer saveInDatabase(UserRegisterRequestDTO userRegisterRequestDTO, String keycloakId) {
        Customer customer = new Customer();
        customer.setEmail(userRegisterRequestDTO.getEmail());
        customer.setName(userRegisterRequestDTO.getName());
        customer.setSurname(userRegisterRequestDTO.getSurname());
        customer.setKeycloakId(keycloakId);

        LOG.info("Saving user in database");
        this.customerRepository.persist(customer);
        return customer;
    }

    private void getAdminRealmToken() {
        AdminRealmRequestDTO adminRealmRequestDTO = new AdminRealmRequestDTO();
        adminRealmRequestDTO.setClient_id("admin-cli");
        adminRealmRequestDTO.setGrant_type("password");
        adminRealmRequestDTO.setUsername(this.adminUsername);
        adminRealmRequestDTO.setPassword(this.adminPassword);
        this.adminRealmResponseDTO = this.keycloakRESTAdminService.getAdminRealmToken(adminRealmRequestDTO);
    }

    private UserResponseDTO getUserByUsername(String username) {
        String bearerToken = "Bearer " + this.adminRealmResponseDTO.getAccess_token();
        UserResponseDTO[] userResponseDTOs = this.keycloakRESTAdminService.getUsers(bearerToken, usersRealm, username, true);
        if (userResponseDTOs.length == 0) {
            throw new KeycloakUserNotFoundException("User not found in keycloak");
        }
        return userResponseDTOs[0];
    }

    private RoleResponseDTO getRoleByName(String name) {
        LOG.info("Getting role from keycloak");
        String bearerToken = "Bearer " + this.adminRealmResponseDTO.getAccess_token();
        RoleResponseDTO[] roleResponseDTOs = this.keycloakRESTAdminService.getRoles(bearerToken, usersRealm);
        if (roleResponseDTOs.length == 0) {
            throw new KeycloakRoleNotFoundException("Role not found in keycloak");
        }
        return Arrays.stream(roleResponseDTOs).filter(roleResponseDTO -> roleResponseDTO.getName().equals(name)).findFirst().orElseThrow(KeycloakRoleNotFoundException::new);
    }

    private void syncUserRealm(String userId, RoleResponseDTO role) {
        LOG.info("Syncing user realm");
        String bearerToken = "Bearer " + this.adminRealmResponseDTO.getAccess_token();
        UserRoleRequestDTO[] userRoleRequestDTOs = new UserRoleRequestDTO[1];
        userRoleRequestDTOs[0] = new UserRoleRequestDTO();
        userRoleRequestDTOs[0].setId(role.getId());
        userRoleRequestDTOs[0].setName(role.getName());
        this.keycloakRESTAdminService.syncUserRoles(bearerToken, usersRealm, userId, userRoleRequestDTOs);
    }
}
