package com.pda1.project.user.controller;

import com.pda1.project.domain.InterestItem.InterestItem;
import com.pda1.project.domain.UserInformation.UserInformation;
import com.pda1.project.domain.UserInformation.UserInformationRepository;
import com.pda1.project.user.controller.Response.AuthenticationResponse;
import com.pda1.project.user.controller.Response.Interest;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jootopia/v1/users")
public class UserManageController {

    private final UserService userService;
    private final UserInformationRepository userInformationRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserInformationDetailService userInformationDetailService;



    @PostMapping("/register")
    @ApiOperation(value = "회원가입")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserRegisterRequest request) {
        Map<String, Object> result = this.userService.create(request.toServiceDto());

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
        UserInformation foundUser = userService.findUser(account);

        if (!passwordEncoder.matches(authenticationRequest.getPassword(), foundUser.getPassword())) {
            return ResponseEntity.ok("Password invalid");
        }

        final UserDetails userDetails = userInformationDetailService.loadUserByUsername(account);
        // final String token = jwtUtils.generateToken(userDetails, adminData.getRoles());
        final String token = jwtUtils.createToken(userDetails.getUsername(), foundUser.getRoles());
        final UserInformation user = userInformationDetailService.getUserInformation(account);

        String type = userService.getType(foundUser);
        List<InterestItem> items = userService.getInterestItem(foundUser);
        Interest interest = Interest.builder().item1(items.get(0).getItem().getTheme()).item2(items.get(1).getItem().getTheme()).item3(items.get(2).getItem().getTheme()).build();

        return ResponseEntity.ok(new AuthenticationResponse(token, type, interest, user));
    }

    @PostMapping("/logout")
    @ApiOperation(value = "로그아웃 API")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        // 현재 인증된 사용자의 인증 토큰을 가져온다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 인증 토큰이 존재하면 로그아웃 처리를 한다.
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return ResponseEntity.ok("로그아웃되었습니다.");
    }

}
