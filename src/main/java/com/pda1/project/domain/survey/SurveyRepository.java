package com.pda1.project.domain.survey;

import com.pda1.project.domain.UserInformation.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey,Long> {
    Optional<Survey> findByUserInformation(UserInformation user);
}
