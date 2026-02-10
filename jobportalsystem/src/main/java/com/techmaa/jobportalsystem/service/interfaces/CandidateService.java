package com.techmaa.jobportalsystem.service.interfaces;

import com.techmaa.jobportalsystem.dto.candidate.CandidateCreateDTO;
import com.techmaa.jobportalsystem.dto.candidate.CandidateResponseDTO;

public interface CandidateService {

    // Create Candidate Profile
    CandidateResponseDTO createCandidateProfile(Long userId, CandidateCreateDTO dto);

    // Get Candidate Profile by UserId
    CandidateResponseDTO getCandidateByUserId(Long userId);
}
