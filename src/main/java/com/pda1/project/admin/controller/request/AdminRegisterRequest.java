package com.pda1.project.admin.controller.request;

import com.pda1.project.admin.service.dto.AdminRegisterDTO;
import com.pda1.project.user.service.dto.UserRegisterDTO;
import com.sun.istack.NotNull;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminRegisterRequest {
    @NotNull
    private String account;   // 로그인 할 때 쓰는 아이디

    @NotNull
    private String password;


    public AdminRegisterDTO toServiceDto(){
        return AdminRegisterDTO.of(account, password);
    }
}
