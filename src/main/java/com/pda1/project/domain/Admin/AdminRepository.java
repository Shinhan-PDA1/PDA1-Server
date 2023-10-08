package com.pda1.project.domain.Admin;

import com.pda1.project.domain.UserInformation.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByAccount(String account);
}
