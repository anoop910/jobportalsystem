package com.techmaa.jobportalsystem.service.impl;

import com.techmaa.jobportalsystem.dto.application.ApplicationResponseDTO;
import com.techmaa.jobportalsystem.entity.*;
import com.techmaa.jobportalsystem.repository.*;
import com.techmaa.jobportalsystem.service.interfaces.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;
    private final CandidateRepository candidateRepository;

    @Override
    public ApplicationResponseDTO applyJob(Long candidateId, Long jobId) {

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (applicationRepository.existsByJobAndCandidate(job, candidate)) {
            throw new RuntimeException("Already applied!");
        }

        Application application = Application.builder()
                .candidate(candidate)
                .job(job)
                .applicationStatus(ApplicationStatus.APPLIED)
                .build();

        applicationRepository.save(application);

        return mapToDTO(application);
    }

    @Override
    public List<ApplicationResponseDTO> getApplicantsForJob(Long jobId) {
        return applicationRepository.findByJobJobId(jobId)
                .stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationResponseDTO> getApplicationsByCandidate(Long candidateId) {
        return applicationRepository.findByCandidateCandidateId(candidateId)
                .stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ApplicationResponseDTO mapToDTO(Application app) {
        return ApplicationResponseDTO.builder()
                .applicationId(app.getApplicationId())
                .jobId(app.getJob().getJobId())
                .jobTitle(app.getJob().getTitle())
                .candidateId(app.getCandidate().getCandidateId())
                .candidateName(app.getCandidate().getUser().getFullName())
                .status(app.getApplicationStatus().name())
                .build();
    }
}
