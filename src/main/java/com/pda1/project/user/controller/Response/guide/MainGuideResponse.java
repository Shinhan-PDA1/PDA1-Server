package com.pda1.project.user.controller.Response.guide;

import com.pda1.project.user.controller.Response.main.InterestList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class MainGuideResponse {

    private Map<String,String> result;
}
