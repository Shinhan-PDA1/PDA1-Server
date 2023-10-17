package com.pda1.project.user.controller.Response.main.shinhan;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pda1.project.user.service.dto.shinhan.MarketDataDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class MarketDataBody {

    @JsonProperty("list")
    private List<MarketDataDTO> list;

}
