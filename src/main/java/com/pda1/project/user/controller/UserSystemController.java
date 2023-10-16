package com.pda1.project.user.controller;

import com.pda1.project.user.controller.Response.MainDetailResponse;
import com.pda1.project.user.controller.Response.MainInterestResponse;
import com.pda1.project.user.controller.request.UserFilterRequest;
import com.pda1.project.user.controller.request.UserRegisterRequest;
import com.pda1.project.user.service.UserSystemService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jootopia/v1/users/system")
public class UserSystemController {

    private final UserSystemService userSystemService;

    @PostMapping("/filter")
    @ApiOperation(value = "설문조사")
    public ResponseEntity<?> saveFilter(@RequestBody UserFilterRequest request, Principal principal) {
        System.out.println("@@@ : " + principal.getName());
        userSystemService.saveFilterInfo(request.toServiceDto(), principal.getName());

        return ResponseEntity.ok("저장되었습니다.");

    }

    @GetMapping("/interest")
    public ResponseEntity<?> getInterestItems(Principal principal) {
        MainInterestResponse response = userSystemService.getInterestItems(principal);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getDetailInformation(@RequestParam String stockCode) {
        MainDetailResponse response = userSystemService.getDetailInformation(stockCode);
        return ResponseEntity.ok(response);
    }

}
