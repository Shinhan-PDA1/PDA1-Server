package com.pda1.project.user.controller.Response.main.shinhan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class MainIssueResponse {

    private String stock_code;
    private String stock_name;
    private int rank;

}
