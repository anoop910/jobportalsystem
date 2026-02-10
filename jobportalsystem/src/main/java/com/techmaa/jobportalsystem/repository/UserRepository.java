package com.techmaa.jobportalsystem.repository;

import com.techmaa.jobportalsystem.entity.User;
import com.techmaa.jobportalsystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(Role role);

    boolean existsByEmail(String email);
}
