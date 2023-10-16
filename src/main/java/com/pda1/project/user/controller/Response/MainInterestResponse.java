package com.pda1.project.user.controller.Response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class MainInterestResponse {

    private List<InterestList> response = new ArrayList<>();

}
