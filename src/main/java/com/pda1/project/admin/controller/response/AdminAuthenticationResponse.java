package com.pda1.project.admin.controller.response;

import com.pda1.project.domain.Admin.Admin;
import com.pda1.project.domain.UserInformation.UserInformation;
import lombok.Getter;

@Getter
public class AdminAuthenticationResponse {
    private final String jwt;
    private final Admin admin;

    public AdminAuthenticationResponse(String jwt, Admin admin) {
        this.jwt = jwt;
        this.admin = admin;
    }
}
