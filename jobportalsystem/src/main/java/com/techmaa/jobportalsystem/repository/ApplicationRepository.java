package com.techmaa.jobportalsystem.repository;
import com.techmaa.jobportalsystem.entity.Application;
import com.techmaa.jobportalsystem.entity.Candidate;
import com.techmaa.jobportalsystem.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByJobJobId(Long jobId);

    List<Application> findByCandidateCandidateId(Long candidateId);

    Optional<Application> findByJobAndCandidate(Job job, Candidate candidate);

    boolean existsByJobAndCandidate(Job job, Candidate candidate);
}
