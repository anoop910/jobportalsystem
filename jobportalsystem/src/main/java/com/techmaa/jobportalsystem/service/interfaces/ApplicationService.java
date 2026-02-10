package com.techmaa.jobportalsystem.service.interfaces;

import com.techmaa.jobportalsystem.dto.application.ApplicationResponseDTO;

import java.util.List;

public interface ApplicationService {

    // Candidate applies for job
    ApplicationResponseDTO applyJob(Long candidateId, Long jobId);

    // Employer views applicants for a job
    List<ApplicationResponseDTO> getApplicantsForJob(Long jobId);

    // Candidate views all applied jobs
    List<ApplicationResponseDTO> getApplicationsByCandidate(Long candidateId);
}
