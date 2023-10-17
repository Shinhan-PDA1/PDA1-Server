package com.pda1.project.user.service.dto.shinhan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MarketDataDTO {

    @JsonProperty("reg_date")
    private String date;

    @JsonProperty("content")
    private String content;

    @JsonProperty("bbs_name")
    private String name;

    @JsonProperty("attachment_url")
    private String url;

}
