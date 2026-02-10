package com.techmaa.jobportalsystem.dto.admin;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminVerificationResponseDTO {

    private Long verificationId;
    private String targetType;
    private String action;
    private String remarks;
    private String verifiedAt;
}
