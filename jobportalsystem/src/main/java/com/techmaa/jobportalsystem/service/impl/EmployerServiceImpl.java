package com.techmaa.jobportalsystem.service.impl;

import com.techmaa.jobportalsystem.dto.employer.*;
import com.techmaa.jobportalsystem.entity.Employer;
import com.techmaa.jobportalsystem.entity.User;
import com.techmaa.jobportalsystem.repository.EmployerRepository;
import com.techmaa.jobportalsystem.repository.UserRepository;
import com.techmaa.jobportalsystem.service.interfaces.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;
    private final UserRepository userRepository;

    @Override
    public EmployerResponseDTO createEmployerProfile(Long userId, EmployerCreateDTO dto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Employer employer = Employer.builder()
                .user(user)
                .companyName(dto.getCompanyName())
                .companyAddress(dto.getCompanyAddress())
                .companyWebsite(dto.getCompanyWebsite())
                .isVerified(false)
                .build();

        employerRepository.save(employer);

        return EmployerResponseDTO.builder()
                .employerId(employer.getEmployerId())
                .companyName(employer.getCompanyName())
                .companyWebsite(employer.getCompanyWebsite())
                .verified(employer.isVerified())
                .build();
    }

    @Override
    public EmployerResponseDTO getEmployerByUserId(Long userId) {

        Employer employer = employerRepository.findByUserUserId(userId)
                .orElseThrow(() -> new RuntimeException("Employer not found"));

        return EmployerResponseDTO.builder()
                .employerId(employer.getEmployerId())
                .companyName(employer.getCompanyName())
                .companyWebsite(employer.getCompanyWebsite())
                .verified(employer.isVerified())
                .build();
    }
}
