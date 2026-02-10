package com.techmaa.jobportalsystem.service.interfaces;

import com.techmaa.jobportalsystem.dto.auth.LoginRequestDTO;
import com.techmaa.jobportalsystem.dto.auth.RegisterRequestDTO;
import com.techmaa.jobportalsystem.dto.auth.AuthResponseDTO;

public interface AuthService {

    // Register new user (Employer or Candidate)
    AuthResponseDTO register(RegisterRequestDTO request);

    // Login user and return JWT Token response
    AuthResponseDTO login(LoginRequestDTO request);
}
