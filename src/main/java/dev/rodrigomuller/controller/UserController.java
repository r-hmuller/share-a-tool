package dev.rodrigomuller.controller;


import dev.rodrigomuller.DTO.request.UserRegisterRequestDTO;
import dev.rodrigomuller.DTO.response.UserRegisterResponseDTO;
import dev.rodrigomuller.service.auth.AuthService;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/users")
@ApplicationScoped
public class UserController {

    private final AuthService authService;
    UserController(AuthService authService) {
        this.authService = authService;
    }

    @POST
    @Blocking
    public UserRegisterResponseDTO register(@Valid UserRegisterRequestDTO userRegisterRequestDTO) {
        return this.authService.register(userRegisterRequestDTO);
    }
}
