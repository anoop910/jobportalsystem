package com.techmaa.jobportalsystem.service.interfaces;

import com.techmaa.jobportalsystem.dto.resume.ResumeResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResumeService {

    // Upload Resume for Candidate
    String uploadResume(Long candidateId, MultipartFile file);

    // Get all resumes of candidate
    List<ResumeResponseDTO> getResumesByCandidate(Long candidateId);
}
