package com.pda1.project.user.controller.Response.main.shinhan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class MainStrategyResponse {

    private String date;
    private String title;
    private String name;
    private String url;

}
