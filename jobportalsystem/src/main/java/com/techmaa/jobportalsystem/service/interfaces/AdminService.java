package com.techmaa.jobportalsystem.service.interfaces;

public interface AdminService {

    String verifyEmployer(Long adminId, Long employerId, boolean approve);

    String verifyJob(Long adminId, Long jobId, boolean approve);

    String blockUser(Long userId);
}
