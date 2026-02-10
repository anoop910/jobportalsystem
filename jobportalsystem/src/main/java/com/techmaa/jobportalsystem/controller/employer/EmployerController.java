package com.techmaa.jobportalsystem.controller.employer;

import com.techmaa.jobportalsystem.dto.employer.*;
import com.techmaa.jobportalsystem.dto.job.JobRequestDTO;
import com.techmaa.jobportalsystem.dto.job.JobResponseDTO;
import com.techmaa.jobportalsystem.service.interfaces.EmployerService;
import com.techmaa.jobportalsystem.service.interfaces.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employer")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;
    private final JobService jobService;

    // Create Employer Profile
    @PostMapping("/profile/{userId}")
    public ResponseEntity<EmployerResponseDTO> createProfile(
            @PathVariable Long userId,
            @RequestBody EmployerCreateDTO dto) {

        return ResponseEntity.ok(employerService.createEmployerProfile(userId, dto));
    }

    // Post Job
    @PostMapping("/post-job/{employerId}")
    public ResponseEntity<JobResponseDTO> postJob(
            @PathVariable Long employerId,
            @RequestBody JobRequestDTO dto) {

        return ResponseEntity.ok(jobService.postJob(employerId, dto));
    }
}
