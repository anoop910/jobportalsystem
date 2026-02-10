package com.techmaa.jobportalsystem.controller.candidate;

import com.techmaa.jobportalsystem.dto.application.ApplicationResponseDTO;
import com.techmaa.jobportalsystem.dto.candidate.*;
import com.techmaa.jobportalsystem.service.interfaces.ApplicationService;
import com.techmaa.jobportalsystem.service.interfaces.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;
    private final ApplicationService applicationService;

    // Create Candidate Profile
    @PostMapping("/profile/{userId}")
    public ResponseEntity<CandidateResponseDTO> createProfile(
            @PathVariable Long userId,
            @RequestBody CandidateCreateDTO dto) {

        return ResponseEntity.ok(candidateService.createCandidateProfile(userId, dto));
    }

    // Apply Job
    @PostMapping("/apply/{candidateId}/{jobId}")
    public ResponseEntity<ApplicationResponseDTO> applyJob(
            @PathVariable Long candidateId,
            @PathVariable Long jobId) {

        return ResponseEntity.ok(applicationService.applyJob(candidateId, jobId));
    }

    // View Candidate Applications
    @GetMapping("/applications/{candidateId}")
    public ResponseEntity<?> myApplications(@PathVariable Long candidateId) {

        return ResponseEntity.ok(
                applicationService.getApplicationsByCandidate(candidateId)
        );
    }
}
