package com.pda1.project.user.controller.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class ChartTableResponse {

    @JsonProperty("annual_high")
    private String annual_high;

    @JsonProperty("annual_low")
    private String annual_low;

    @JsonProperty("stock_market")
    private String stock_market;

    @JsonProperty("capital")
    private String capital;

    @JsonProperty("listed_stock_number")
    private String listed_stock_number;

    @JsonProperty("market_capital")
    private String market_capital;

    @JsonProperty("per")
    private String per;

    @JsonProperty("eps")
    private String eps;
}
