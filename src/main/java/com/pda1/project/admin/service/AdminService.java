package com.pda1.project.admin.service;

import com.pda1.project.admin.service.dto.AdminRegisterDTO;
import com.pda1.project.domain.Admin.Admin;
import com.pda1.project.domain.Admin.AdminRepository;
import com.pda1.project.domain.UserInformation.UserInformation;
import com.pda1.project.domain.UserInformation.UserInformationRepository;
import com.pda1.project.user.service.dto.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public Map<String, Object> create(AdminRegisterDTO dto) {
        Map<String, Object> resultMap = new HashMap<>();

        // 아이디가 중복되었을 때
        if (this.adminRepository.findByAccount(dto.getAccount()).isPresent()) {
            resultMap.put("success", false);
            resultMap.put("message", "중복된 아이디입니다.");

            return resultMap;
        }

        System.out.println(dto);
        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        Admin newAdmin =
                Admin.builder()
                    .account(dto.getAccount())
                    .password(encodedPassword)
                    .roles(Collections.singletonList("ROLE_ADMIN"))
                .build();

        try {
            this.adminRepository.save(newAdmin);
            resultMap.put("success", true);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("message", e.getMessage());
        }

        return resultMap;
    }
}

