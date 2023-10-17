package com.pda1.project.user.controller.Response.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pda1.project.user.controller.Response.detail.ChartData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class MainChartResponse {

    @JsonProperty("chartData")
    private List<ChartData> chartData;

}
