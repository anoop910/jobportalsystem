package com.techmaa.jobportalsystem.dto.candidate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCreateDTO {

    private String phone;
    private String skills;
    private int experienceYears;
}
