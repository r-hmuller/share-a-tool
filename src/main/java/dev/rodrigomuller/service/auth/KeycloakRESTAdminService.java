package dev.rodrigomuller.service.auth;

import dev.rodrigomuller.DTO.restclient.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface KeycloakRESTAdminService {
    @POST
    @Path("/realms/master/protocol/openid-connect/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    AdminRealmResponseDTO getAdminRealmToken(@BeanParam AdminRealmRequestDTO adminRealmRequestDTO);

    @POST
    @Path("/admin/realms/{realm}/users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    CreateUserResponseDTO createUser(@HeaderParam("Authorization") String token, @PathParam("realm") String param, CreateUserRequestDTO createUserRequestDTO);

    @GET
    @Path("/admin/realms/{realm}/users")
    @Produces(MediaType.APPLICATION_JSON)
    UserResponseDTO[] getUsers(@HeaderParam("Authorization") String token,
                               @PathParam("realm") String param,
                               @QueryParam("username") String username,
                               @QueryParam("exact") boolean exact);

    @DELETE
    @Path("/admin/realms/{realm}/users/{id}")
    void deleteUser(@HeaderParam("Authorization") String token,
                    @PathParam("realm") String param,
                    @PathParam("id") String id);
}
