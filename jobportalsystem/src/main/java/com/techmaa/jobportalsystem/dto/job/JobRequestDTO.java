package com.techmaa.jobportalsystem.dto.job;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobRequestDTO {

    private String title;
    private String description;
    private String location;
    private BigDecimal salary;
}
