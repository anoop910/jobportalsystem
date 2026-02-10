package com.techmaa.jobportalsystem.controller.resume;

import com.techmaa.jobportalsystem.dto.resume.ResumeResponseDTO;
import com.techmaa.jobportalsystem.service.interfaces.ResumeService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/upload/{candidateId}")
    public ResponseEntity<String> uploadResume(
            @PathVariable Long candidateId,
            @RequestParam("file") MultipartFile file) {

        return ResponseEntity.ok(resumeService.uploadResume(candidateId, file));
    }

    @GetMapping("/{candidateId}")
    public ResponseEntity<List<ResumeResponseDTO>> getResumes(
            @PathVariable Long candidateId) {

        return ResponseEntity.ok(
                resumeService.getResumesByCandidate(candidateId));
    }

}
