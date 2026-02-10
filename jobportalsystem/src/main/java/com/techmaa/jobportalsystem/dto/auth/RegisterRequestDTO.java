package com.techmaa.jobportalsystem.dto.auth;

import com.techmaa.jobportalsystem.entity.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    private String fullName;
    private String email;
    private String password;

    private Role role; // EMPLOYER or CANDIDATE
}
