package dev.rodrigomuller.service.auth;


import dev.rodrigomuller.DTO.request.UserRegisterRequestDTO;
import dev.rodrigomuller.DTO.response.UserRegisterResponseDTO;

public interface AuthService {
    public UserRegisterResponseDTO register(UserRegisterRequestDTO userRegisterRequestDTO);
}
