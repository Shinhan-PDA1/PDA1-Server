package com.pda1.project.user.service.dto.shinhan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class IssueDataDTO {

    @JsonProperty("rank")
    private int rank;

    @JsonProperty("stbd_nm")
    private String stockName;

    @JsonProperty("stock_code")
    private String stockCode;

}
