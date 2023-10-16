package com.pda1.project.domain.InterestItem;

import com.pda1.project.domain.UserInformation.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InterestItemRepository extends JpaRepository<InterestItem,Long> {

    //Optional<InterestItem> findByUserInformation(UserInformation user);

    List<InterestItem> findAllByUserInformation(UserInformation user);
}
