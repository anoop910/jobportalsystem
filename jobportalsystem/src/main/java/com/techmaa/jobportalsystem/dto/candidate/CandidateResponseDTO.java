package com.techmaa.jobportalsystem.dto.candidate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateResponseDTO {

    private Long candidateId;
    private String phone;
    private String skills;
    private int experienceYears;
}
