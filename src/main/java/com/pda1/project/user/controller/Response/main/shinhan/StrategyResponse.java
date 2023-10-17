package com.pda1.project.user.controller.Response.main.shinhan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StrategyResponse {

    @JsonProperty("dataBody")
    private StrategyDataBody strategyDataBody;

}
