package com.pda1.project.user.controller.Response;

import com.pda1.project.user.service.dto.ItemDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class InterestList {

    private String theme;
    private List<ItemDTO> items;

}
