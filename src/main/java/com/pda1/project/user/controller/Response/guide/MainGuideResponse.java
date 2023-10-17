package com.pda1.project.user.controller.Response.guide;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pda1.project.user.service.dto.GuideDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class MainGuideResponse {

    @JsonProperty("response")
    private List<GuideDTO> response;
}
