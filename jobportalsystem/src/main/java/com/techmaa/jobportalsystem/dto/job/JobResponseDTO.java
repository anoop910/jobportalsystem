package com.techmaa.jobportalsystem.dto.job;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobResponseDTO {

    private Long jobId;

    private String title;
    private String description;
    private String location;
    private BigDecimal salary;

    private String status;

    private String companyName;
}
