package com.pda1.project.user.controller.Response;

import com.pda1.project.domain.UserInformation.UserInformation;
import lombok.Getter;

@Getter
public class AuthenticationResponse {
    private final String jwt;
    private final Boolean isSurvey;
    private final UserInformation userInformation;

    public AuthenticationResponse(String jwt, Boolean isSurvey, UserInformation userInformation) {
        this.jwt = jwt;
        this.isSurvey = isSurvey;
        this.userInformation = userInformation;
    }
}
