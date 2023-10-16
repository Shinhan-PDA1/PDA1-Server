package com.pda1.project.user.controller.Response;

import com.pda1.project.domain.UserInformation.UserInformation;
import lombok.Getter;

@Getter
public class AuthenticationResponse {
    private final String jwt;
    private final UserInformation userInformation;

    public AuthenticationResponse(String jwt, UserInformation userInformation) {
        this.jwt = jwt;
        this.userInformation = userInformation;
    }
}
