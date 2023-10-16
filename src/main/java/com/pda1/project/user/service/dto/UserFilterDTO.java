package com.pda1.project.user.service.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFilterDTO {

    private String investExperience;
    private String age;
    private String investPeriod;
    private String revenueTrend;
    private List<String> interestTopic;

    public static UserFilterDTO of(String investExperience, String age, String investPeriod, String revenueTrend, List<String> interestTopic){
        return new UserFilterDTO(investExperience, age, investPeriod, revenueTrend, interestTopic);
    }
}
