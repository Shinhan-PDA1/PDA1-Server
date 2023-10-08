package com.pda1.project.admin.service.dto;

import com.pda1.project.user.service.dto.UserRegisterDTO;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminRegisterDTO {

    private String account;   // 로그인 할 때 쓰는 아이디
    private String password;


    public static AdminRegisterDTO of(String account, String password){
        return new AdminRegisterDTO(account, password);
    }
}
