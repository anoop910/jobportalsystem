package com.techmaa.jobportalsystem.service.impl;

import com.techmaa.jobportalsystem.entity.*;
import com.techmaa.jobportalsystem.repository.*;
import com.techmaa.jobportalsystem.service.interfaces.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final EmployerRepository employerRepository;
    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final AdminVerificationRepository verificationRepository;

    // ✅ Manual Constructor Injection
    public AdminServiceImpl(EmployerRepository employerRepository,
                            JobRepository jobRepository,
                            UserRepository userRepository,
                            AdminVerificationRepository verificationRepository) {

        this.employerRepository = employerRepository;
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.verificationRepository = verificationRepository;
    }

    @Override
    public String verifyEmployer(Long adminId, Long employerId, boolean approve) {

        Employer employer = employerRepository.findById(employerId)
                .orElseThrow(() -> new RuntimeException("Employer not found"));

        employer.setVerified(approve);
        employerRepository.save(employer);

        saveVerificationLog(adminId, TargetType.EMPLOYER, employerId, approve);

        return approve ? "Employer Verified Successfully!"
                       : "Employer Rejected!";
    }

    @Override
    public String verifyJob(Long adminId, Long jobId, boolean approve) {

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setStatus(approve ? JobStatus.APPROVED : JobStatus.REJECTED);
        jobRepository.save(job);

        saveVerificationLog(adminId, TargetType.JOB, jobId, approve);

        return approve ? "Job Approved Successfully!"
                       : "Job Rejected!";
    }

    @Override
    public String blockUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setActive(false);
        userRepository.save(user);

        return "User Blocked Successfully!";
    }

    private void saveVerificationLog(Long adminId,
                                     TargetType targetType,
                                     Long targetId,
                                     boolean approve) {

        User admin = userRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        AdminVerification log = new AdminVerification();
        log.setAdmin(admin);
        log.setTargetType(targetType);
        log.setTargetId(targetId);

        log.setAction(approve ? VerificationAction.APPROVED
                              : VerificationAction.REJECTED);

        log.setRemarks(approve ? "Approved by Admin"
                               : "Rejected by Admin");

        verificationRepository.save(log);
    }
}
