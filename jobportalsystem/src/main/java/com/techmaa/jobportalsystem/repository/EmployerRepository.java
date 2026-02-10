package com.techmaa.jobportalsystem.repository;


import com.techmaa.jobportalsystem.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

    Optional<Employer> findByUserUserId(Long userId);

    List<Employer> findByIsVerifiedFalse();

    List<Employer> findByIsVerifiedTrue();
}
