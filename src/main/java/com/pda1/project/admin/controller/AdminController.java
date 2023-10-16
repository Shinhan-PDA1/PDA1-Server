package com.pda1.project.admin.controller;

import com.pda1.project.admin.controller.request.AdminRegisterRequest;
import com.pda1.project.admin.controller.response.AdminAuthenticationResponse;
import com.pda1.project.admin.service.AdminDetailService;
import com.pda1.project.admin.service.AdminService;
import com.pda1.project.domain.Admin.Admin;
import com.pda1.project.domain.Admin.AdminRepository;
import com.pda1.project.domain.UserInformation.UserInformation;
import com.pda1.project.domain.UserInformation.UserInformationRepository;
import com.pda1.project.user.controller.Response.AuthenticationResponse;
import com.pda1.project.user.controller.request.AuthenticationRequest;
import com.pda1.project.user.controller.request.UserRegisterRequest;
import com.pda1.project.user.service.UserInformationDetailService;
import com.pda1.project.user.service.UserService;
import com.pda1.project.utility.JwtUtils;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admins")
public class AdminController {

    private final AdminService adminService;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AdminDetailService adminDetailService;



    @PostMapping("/register")
    @ApiOperation(value = "회원가입")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody AdminRegisterRequest request) {
        Map<String, Object> result = this.adminService.create(request.toServiceDto());

        if ((Boolean) result.get("success")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인 API")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        String account = authenticationRequest.getAccount();

        Admin foundAdmin = adminRepository.findByAccount(account).orElse(null);

        if (!passwordEncoder.matches(authenticationRequest.getPassword(), foundAdmin.getPassword())) {
            return ResponseEntity.ok("Password invalid");
        }
        final UserDetails userDetails = adminDetailService.loadUserByUsername(account);
        // final String token = jwtUtils.generateToken(userDetails, adminData.getRoles());
        final String token = jwtUtils.createToken(userDetails.getUsername(), foundAdmin.getRoles());
        final Admin admin = adminDetailService.getUserInformation(account);
        return ResponseEntity.ok(new AdminAuthenticationResponse(token, admin));
    }

//    @PostMapping("/logout")
//    @ApiOperation(value = "로그아웃 API")
//    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
//        // 현재 인증된 사용자의 인증 토큰을 가져온다.
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        // 인증 토큰이 존재하면 로그아웃 처리를 한다.
//        if (authentication != null) {
//            new SecurityContextLogoutHandler().logout(request, response, authentication);
//        }
//
//        return ResponseEntity.ok("로그아웃되었습니다.");
//    }

}
