package com.techmaa.jobportalsystem.dto.resume;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeResponseDTO {

    private Long resumeId;
    private String fileName;
    private String filePath;
}
