package com.techmaa.jobportalsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techmaa.jobportalsystem.entity.Resume;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    List<Resume> findByCandidateCandidateId(Long candidateId);
}
