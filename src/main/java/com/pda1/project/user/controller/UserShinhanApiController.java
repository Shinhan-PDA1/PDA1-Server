package com.pda1.project.user.controller;

import com.pda1.project.user.controller.Response.main.shinhan.*;
import com.pda1.project.user.service.UserShinhanApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jootopia/v1/users/system/shinhan")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserShinhanApiController {

    private final UserShinhanApiService userShinhanApiService;

    @GetMapping("/recommend/portfolio")
    public ResponseEntity<?> recommendFortfolio() {
        List<MainPortfolioResponse> response= userShinhanApiService.getPortfolio();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/ranking/rising")
    public ResponseEntity<?> rankingRising() {
        List<MainPopularResponse> response= userShinhanApiService.getPopular();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/ranking/issue")
    public ResponseEntity<?> rankingIssue(@RequestParam(name = "query_type") String queryType) {
        List<MainIssueResponse> response= userShinhanApiService.getIssue(queryType);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/strategy/invest")
    public ResponseEntity<?> strategyInvest() {
        List<MainStrategyResponse> response= userShinhanApiService.getStrategy();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/strategy/market-issue")
    public ResponseEntity<?> marketIssue() {
        List<MainMarketResponse> response= userShinhanApiService.getMarketIssue();
        return ResponseEntity.ok(response);
    }

}
