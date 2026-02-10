package com.techmaa.jobportalsystem.repository;

import com.techmaa.jobportalsystem.entity.Job;
import com.techmaa.jobportalsystem.entity.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByEmployerEmployerId(Long employerId);

    List<Job> findByStatus(JobStatus status);

    List<Job> findByTitleContainingIgnoreCase(String keyword);
}
