package com.pda1.project.user.service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemDTO {

    private String item_name;
    private String curr_price;
    private String change_number;
    private String change_rate;
    private String stock_code;

}
