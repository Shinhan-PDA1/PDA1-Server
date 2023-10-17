package com.pda1.project.user.controller.Response.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class MainDetailResponse {

    @JsonProperty("mainChartResponse")
    private MainChartResponse mainChartResponse;

    @JsonProperty("chartCommentResponse")
    private ChartCommentResponse chartCommentResponse;

//    @JsonProperty("statementResponse")
//    private StatementResponse statementResponse;

    @JsonProperty("statementCommentResponse")
    private StatementCommentResponse statementCommentResponse;

    @JsonProperty("chartTableResponse")
    private ChartTableResponse chartTableResponse;

}
