package com.techmaa.jobportalsystem.dto.admin;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminVerifyRequestDTO {

    private Long targetId; // employerId or jobId
    private String targetType; // EMPLOYER or JOB
    private String action; // APPROVED or REJECTED
    private String remarks;
}
