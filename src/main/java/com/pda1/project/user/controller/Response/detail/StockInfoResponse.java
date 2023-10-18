package com.pda1.project.user.controller.Response.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class StockInfoResponse {

    @JsonProperty("stockName")
    private String stockName;

    @JsonProperty("price")
    private String price;

    @JsonProperty("rate")
    private String rate;

}
