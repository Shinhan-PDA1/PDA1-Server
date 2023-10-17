package com.pda1.project.user.service.dto.shinhan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PopularDataDTO {

    @JsonProperty("dd_cmpr_rank")
    private String variableRanking;

    @JsonProperty("now_rank")
    private String ranking;

    @JsonProperty("qry_numt")
    private String count;

    @JsonProperty("stbd_nm")
    private String stockName;

    @JsonProperty("stk_indc_code")
    private String category;

    @JsonProperty("stock_code")
    private String stockCode;


}
