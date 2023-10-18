package com.pda1.project.user.controller.Response;

import com.pda1.project.domain.UserInformation.UserInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticationResponse {
    private final String jwt;
    private final String type;
    private final Interest interest;
    private final UserInformation userInformation;
}
