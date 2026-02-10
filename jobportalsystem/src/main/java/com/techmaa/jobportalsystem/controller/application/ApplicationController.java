package com.techmaa.jobportalsystem.controller.application;

import com.techmaa.jobportalsystem.dto.application.ApplicationResponseDTO;
import com.techmaa.jobportalsystem.service.interfaces.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    // Employer View Applicants
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationResponseDTO>> getApplicants(
            @PathVariable Long jobId) {

        return ResponseEntity.ok(applicationService.getApplicantsForJob(jobId));
    }
}
