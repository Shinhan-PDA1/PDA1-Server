package com.pda1.project.user.controller.request;

import com.pda1.project.user.service.dto.UserFilterDTO;
import com.pda1.project.user.service.dto.UserRegisterDTO;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFilterRequest {

    private String investExperience;
    private String age;
    private String investPeriod;
    private String revenueTrend;
    private List<String> interestTopic;

    public UserFilterDTO toServiceDto(){
        return UserFilterDTO.of(investExperience, age, investPeriod, revenueTrend, interestTopic);
    }

}
