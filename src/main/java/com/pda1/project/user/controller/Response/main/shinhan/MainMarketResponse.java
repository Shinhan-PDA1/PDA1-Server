package com.pda1.project.user.controller.Response.main.shinhan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class MainMarketResponse {

    private String date;
    private String content;
    private String name;
    private String url;

}
