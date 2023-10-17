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
public class StatementResponse {

    @JsonProperty("type")
    private String type;

    @JsonProperty("date")
    private String date;

    @JsonProperty("bps")
    private String bps;

    @JsonProperty("eps")
    private String eps;

    @JsonProperty("pbr")
    private String pbr;

    @JsonProperty("per")
    private String per;

    @JsonProperty("roe")
    private String roe;

    @JsonProperty("net_income")
    private String net_income;

    @JsonProperty("quick_ratio")
    private String quick_ratio;

    @JsonProperty("sales")
    private String sales;

    @JsonProperty("dividend_payout_ratio")
    private String dividend_payout_ratio;

    @JsonProperty("debt_ratio")
    private String debt_ratio;

    @JsonProperty("net_profit_margin")
    private String net_profit_margin;

    @JsonProperty("market_odds")
    private String market_odds;

    @JsonProperty("operation_profit_margin")
    private String operation_profit_margin;

    @JsonProperty("retention_rate")
    private String retention_rate;

    @JsonProperty("dividend_per_share")
    private String dividend_per_share;

}
