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
public class StatementCommentResponse {

    @JsonProperty("statement_long_comment")
    private String statement_long_comment;

    @JsonProperty("statement_short_comment")
    private String statement_short_comment;

}
