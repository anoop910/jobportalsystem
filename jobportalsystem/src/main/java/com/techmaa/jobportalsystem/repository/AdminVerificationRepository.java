package com.techmaa.jobportalsystem.repository;

import com.techmaa.jobportalsystem.entity.AdminVerification;
import com.techmaa.jobportalsystem.entity.TargetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminVerificationRepository extends JpaRepository<AdminVerification, Long> {

    List<AdminVerification> findByTargetType(TargetType targetType);

    List<AdminVerification> findByAdminUserId(Long adminId);
}
