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
public class StatementCommentResponse {

    @JsonProperty("statement_comment")
    private String statement_comment;

}
