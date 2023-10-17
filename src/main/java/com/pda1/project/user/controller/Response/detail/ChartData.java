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
public class ChartData {

    @JsonProperty("date")
    private String date;

    @JsonProperty("open_price")
    private String open_price;

    @JsonProperty("close_price")
    private String close_price;

    @JsonProperty("high_price")
    private String high_price;

    @JsonProperty("low_price")
    private String low_price;

    @JsonProperty("trading_volume")
    private String trading_volume;

}
