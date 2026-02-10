package com.techmaa.jobportalsystem.service.impl;

import com.techmaa.jobportalsystem.dto.job.*;
import com.techmaa.jobportalsystem.entity.*;
import com.techmaa.jobportalsystem.repository.*;
import com.techmaa.jobportalsystem.service.interfaces.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final EmployerRepository employerRepository;

    @Override
    public JobResponseDTO postJob(Long employerId, JobRequestDTO dto) {

        Employer employer = employerRepository.findById(employerId)
                .orElseThrow(() -> new RuntimeException("Employer not found"));

        if (!employer.isVerified()) {
            throw new RuntimeException("Employer not verified!");
        }

        Job job = Job.builder()
                .employer(employer)
                .title(dto.getTitle())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .salary(dto.getSalary())
                .status(JobStatus.PENDING)
                .build();

        jobRepository.save(job);

        return mapToDTO(job);
    }

    @Override
    public List<JobResponseDTO> getApprovedJobs() {
        return jobRepository.findByStatus(JobStatus.APPROVED)
                .stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<JobResponseDTO> searchJobs(String keyword) {
        return jobRepository.findByTitleContainingIgnoreCase(keyword)
                .stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobResponseDTO getJobById(Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        return mapToDTO(job);
    }

    private JobResponseDTO mapToDTO(Job job) {
        return JobResponseDTO.builder()
                .jobId(job.getJobId())
                .title(job.getTitle())
                .description(job.getDescription())
                .location(job.getLocation())
                .salary(job.getSalary())
                .status(job.getStatus().name())
                .companyName(job.getEmployer().getCompanyName())
                .build();
    }
}
