package com.techmaa.jobportalsystem.dto.application;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationResponseDTO {

    private Long applicationId;

    private Long jobId;
    private String jobTitle;

    private Long candidateId;
    private String candidateName;

    private String status;
}
