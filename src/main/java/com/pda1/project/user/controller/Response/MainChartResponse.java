package com.pda1.project.user.controller.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class MainChartResponse {

    @JsonProperty("chartData")
    private List<ChartData> chartData;

}
