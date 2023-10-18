package com.pda1.project.user.service;

import com.pda1.project.domain.InterestItem.InterestItem;
import com.pda1.project.domain.InterestItem.InterestItemRepository;
import com.pda1.project.domain.UserInformation.UserInformation;
import com.pda1.project.domain.UserInformation.UserInformationRepository;
import com.pda1.project.domain.survey.Survey;
import com.pda1.project.domain.survey.SurveyRepository;
import com.pda1.project.user.service.dto.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserInformationRepository userInformationRepository;
    private final PasswordEncoder passwordEncoder;
    private final SurveyRepository surveyRepository;
    private final InterestItemRepository interestItemRepository;

    public Map<String, Object> create(UserRegisterDTO dto) {
        Map<String, Object> resultMap = new HashMap<>();

        // 아이디가 중복되었을 때
        if (this.userInformationRepository.findByAccount(dto.getAccount()).isPresent()) {
            resultMap.put("success", false);
            resultMap.put("message", "중복된 아이디입니다.");
            return resultMap;
        }
        System.out.println(dto);
        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        UserInformation newUser =
                UserInformation.builder()
                    .account(dto.getAccount())
                    .password(encodedPassword)
                    .name(dto.getName())
                    .email(dto.getEmail())
                    .roles(Collections.singletonList("ROLE_USER"))
                .build();

        try {
            this.userInformationRepository.save(newUser);
            resultMap.put("success", true);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("message", e.getMessage());
        }

        return resultMap;
    }

    public UserInformation findUser(String account) {
        return userInformationRepository.findByAccount(account).orElseThrow();
    }

    public Boolean validSurvey(UserInformation user) {

        if(surveyRepository.findByUserInformation(user).isPresent()) return true;
        else return false;

    }

    public String getType(UserInformation user) {

        Survey survey = surveyRepository.findByUserInformation(user).orElse(null);
        if(Objects.isNull(survey)) return null;
        return survey.getInvestPeriod();
    }

    public List<InterestItem> getInterestItem(UserInformation foundUser) {

        return interestItemRepository.findAllByUserInformation(foundUser);

    }
}
