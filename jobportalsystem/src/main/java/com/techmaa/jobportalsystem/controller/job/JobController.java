package com.techmaa.jobportalsystem.controller.job;

import com.techmaa.jobportalsystem.dto.job.JobResponseDTO;
import com.techmaa.jobportalsystem.service.interfaces.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    // View Approved Jobs
    @GetMapping("/approved")
    public ResponseEntity<List<JobResponseDTO>> getApprovedJobs() {

        return ResponseEntity.ok(jobService.getApprovedJobs());
    }

    // Search Jobs
    @GetMapping("/search")
    public ResponseEntity<List<JobResponseDTO>> searchJobs(
            @RequestParam String keyword) {

        return ResponseEntity.ok(jobService.searchJobs(keyword));
    }

    // Get Job Details
    @GetMapping("/{jobId}")
    public ResponseEntity<JobResponseDTO> getJob(@PathVariable Long jobId) {

        return ResponseEntity.ok(jobService.getJobById(jobId));
    }
}
