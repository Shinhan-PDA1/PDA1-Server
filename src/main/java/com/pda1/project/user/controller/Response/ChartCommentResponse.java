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
public class ChartCommentResponse {

    @JsonProperty("chart_long_comment")
    private String chart_long_comment;

    @JsonProperty("chart_short_comment")
    private String chart_short_comment;
}
