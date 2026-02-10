package com.techmaa.jobportalsystem.service.interfaces;

import com.techmaa.jobportalsystem.dto.job.JobRequestDTO;
import com.techmaa.jobportalsystem.dto.job.JobResponseDTO;

import java.util.List;

public interface JobService {

    // Employer posts a new job
    JobResponseDTO postJob(Long employerId, JobRequestDTO dto);

    // Candidate views all approved jobs
    List<JobResponseDTO> getApprovedJobs();

    // Search jobs by keyword
    List<JobResponseDTO> searchJobs(String keyword);

    // Get job details by Id
    JobResponseDTO getJobById(Long jobId);
}
