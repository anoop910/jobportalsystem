package com.techmaa.jobportalsystem.controller.admin;

import com.techmaa.jobportalsystem.service.interfaces.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    // ✅ Manual Constructor Injection
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/verify-employer/{adminId}/{employerId}")
    public ResponseEntity<String> verifyEmployer(
            @PathVariable Long adminId,
            @PathVariable Long employerId,
            @RequestParam boolean approve) {

        return ResponseEntity.ok(
                adminService.verifyEmployer(adminId, employerId, approve)
        );
    }

    @PutMapping("/verify-job/{adminId}/{jobId}")
    public ResponseEntity<String> verifyJob(
            @PathVariable Long adminId,
            @PathVariable Long jobId,
            @RequestParam boolean approve) {

        return ResponseEntity.ok(
                adminService.verifyJob(adminId, jobId, approve)
        );
    }

    @PutMapping("/block-user/{userId}")
    public ResponseEntity<String> blockUser(@PathVariable Long userId) {

        return ResponseEntity.ok(adminService.blockUser(userId));
    }
}
