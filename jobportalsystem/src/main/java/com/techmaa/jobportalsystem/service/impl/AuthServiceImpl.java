package com.techmaa.jobportalsystem.service.impl;

import com.techmaa.jobportalsystem.dto.auth.AuthResponseDTO;
import com.techmaa.jobportalsystem.dto.auth.LoginRequestDTO;
import com.techmaa.jobportalsystem.dto.auth.RegisterRequestDTO;
import com.techmaa.jobportalsystem.entity.User;
import com.techmaa.jobportalsystem.repository.UserRepository;
import com.techmaa.jobportalsystem.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public AuthResponseDTO register(RegisterRequestDTO request) {

        // Check email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        // Save user directly (no encoding)
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(request.getPassword()) // plain password
                .role(request.getRole())
                .isActive(true)
                .build();

        userRepository.save(user);

        return AuthResponseDTO.builder()
                .message("User Registered Successfully!")
                .role(user.getRole().name())
                .token("NO_TOKEN")
                .build();
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        // Plain password match
        if (!request.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        return AuthResponseDTO.builder()
                .message("Login Successful!")
                .role(user.getRole().name())
                .token("NO_TOKEN")
                .build();
    }
}
