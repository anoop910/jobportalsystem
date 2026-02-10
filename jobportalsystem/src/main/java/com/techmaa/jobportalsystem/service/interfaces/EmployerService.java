package com.techmaa.jobportalsystem.service.interfaces;

import com.techmaa.jobportalsystem.dto.employer.EmployerCreateDTO;
import com.techmaa.jobportalsystem.dto.employer.EmployerResponseDTO;

public interface EmployerService {

    // Create Employer Profile
    EmployerResponseDTO createEmployerProfile(Long userId, EmployerCreateDTO dto);

    // Get Employer Profile by UserId
    EmployerResponseDTO getEmployerByUserId(Long userId);
}
