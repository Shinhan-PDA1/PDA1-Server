package com.pda1.project.domain.UserInformation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInformationRepository extends JpaRepository<UserInformation,Long> {
    Optional<UserInformation> findByAccount(String account);
}
