package com.techmaa.jobportalsystem.service.impl;

import com.techmaa.jobportalsystem.dto.candidate.*;
import com.techmaa.jobportalsystem.entity.Candidate;
import com.techmaa.jobportalsystem.entity.User;
import com.techmaa.jobportalsystem.repository.CandidateRepository;
import com.techmaa.jobportalsystem.repository.UserRepository;
import com.techmaa.jobportalsystem.service.interfaces.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final UserRepository userRepository;

    @Override
    public CandidateResponseDTO createCandidateProfile(Long userId, CandidateCreateDTO dto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Candidate candidate = Candidate.builder()
                .user(user)
                .phone(dto.getPhone())
                .skills(dto.getSkills())
                .experienceYears(dto.getExperienceYears())
                .build();

        candidateRepository.save(candidate);

        return CandidateResponseDTO.builder()
                .candidateId(candidate.getCandidateId())
                .phone(candidate.getPhone())
                .skills(candidate.getSkills())
                .experienceYears(candidate.getExperienceYears())
                .build();
    }

    @Override
    public CandidateResponseDTO getCandidateByUserId(Long userId) {

        Candidate candidate = candidateRepository.findByUserUserId(userId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        return CandidateResponseDTO.builder()
                .candidateId(candidate.getCandidateId())
                .phone(candidate.getPhone())
                .skills(candidate.getSkills())
                .experienceYears(candidate.getExperienceYears())
                .build();
    }
}
