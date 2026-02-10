package com.techmaa.jobportalsystem.dto.employer;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployerResponseDTO {

    private Long employerId;
    private String companyName;
    private String companyWebsite;
    private boolean verified;
}
