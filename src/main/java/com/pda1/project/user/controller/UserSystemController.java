package com.pda1.project.user.controller;

import com.pda1.project.user.controller.Response.chatbot.MainChatbotResponse;
import com.pda1.project.user.controller.Response.detail.MainDetailResponse;
import com.pda1.project.user.controller.Response.guide.MainGuideResponse;
import com.pda1.project.user.controller.Response.main.*;
import com.pda1.project.user.controller.request.ChatbotRequest;
import com.pda1.project.user.controller.request.UserFilterRequest;
import com.pda1.project.user.service.UserShinhanApiService;
import com.pda1.project.user.service.UserSystemService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jootopia/v1/users/system")
public class UserSystemController {

    private final UserSystemService userSystemService;

    @PostMapping("/filter")
    @ApiOperation(value = "설문조사")
    public ResponseEntity<?> saveFilter(@RequestBody UserFilterRequest request, Principal principal) {
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

    @PostMapping("/chatbot")
    public ResponseEntity<?> saveConversationAndGetAnswer(@RequestBody ChatbotRequest request, Principal principal) {
        MainChatbotResponse response = userSystemService.saveConversationAndGetAnswer(request.toServiceDto(), principal.getName());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/guide")
    public ResponseEntity<?> getGuideInformation(Principal principal) {
        MainGuideResponse response = userSystemService.getGuideInformation(principal.getName());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getStockCode(@RequestParam String query) {
        String code = userSystemService.getStockCode(query);
        return ResponseEntity.ok(code);
    }




}
