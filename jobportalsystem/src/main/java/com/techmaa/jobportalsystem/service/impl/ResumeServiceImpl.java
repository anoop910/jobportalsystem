package com.techmaa.jobportalsystem.service.impl;

import com.techmaa.jobportalsystem.dto.resume.ResumeResponseDTO;
import com.techmaa.jobportalsystem.entity.Candidate;
import com.techmaa.jobportalsystem.entity.Resume;
import com.techmaa.jobportalsystem.repository.CandidateRepository;
import com.techmaa.jobportalsystem.repository.ResumeRepository;
import com.techmaa.jobportalsystem.service.interfaces.ResumeService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final CandidateRepository candidateRepository;

    public ResumeServiceImpl(ResumeRepository resumeRepository,
                             CandidateRepository candidateRepository) {
        this.resumeRepository = resumeRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public String uploadResume(Long candidateId, MultipartFile file) {

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        if (file.isEmpty()) {
            throw new RuntimeException("File is empty!");
        }

        try {
            // ✅ Create Upload Folder if not exists
            String uploadDir = "uploads/resumes/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // ✅ File Name
            String fileName = candidateId + "_" + file.getOriginalFilename();

            // ✅ Full Path
            Path filePath = uploadPath.resolve(fileName);

            // ✅ Save File
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // ✅ Save in Database
            Resume resume = new Resume();
            resume.setCandidate(candidate);
            resume.setFileName(fileName);
            resume.setFilePath(filePath.toString());

            resumeRepository.save(resume);

            return "Resume Uploaded Successfully!";

        } catch (IOException e) {
            throw new RuntimeException("Resume upload failed: " + e.getMessage());
        }
    }

    @Override
public List<ResumeResponseDTO> getResumesByCandidate(Long candidateId) {

    // ✅ Check Candidate Exists
    candidateRepository.findById(candidateId)
            .orElseThrow(() -> new RuntimeException("Candidate not found with ID: " + candidateId));

    // ✅ Fetch Resumes
    List<Resume> resumes = resumeRepository.findByCandidateCandidateId(candidateId);

    // ✅ Convert Resume → DTO List
    return resumes.stream()
            .map(resume -> new ResumeResponseDTO(
                    resume.getResumeId(),
                    resume.getFileName(),
                    resume.getFilePath()
            ))
            .toList();
}

}
