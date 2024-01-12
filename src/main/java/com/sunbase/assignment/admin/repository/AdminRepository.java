package com.sunbase.assignment.admin.repository;

import com.sunbase.assignment.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
     Optional<Admin> findByEmail(String email);
}
