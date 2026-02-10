package com.techmaa.jobportalsystem.repository;


import com.techmaa.jobportalsystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Optional<Candidate> findByUserUserId(Long userId);
}
