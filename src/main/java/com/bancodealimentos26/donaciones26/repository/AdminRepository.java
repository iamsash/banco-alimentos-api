package com.bancodealimentos26.donaciones26.repository;

import com.bancodealimentos26.donaciones26.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}