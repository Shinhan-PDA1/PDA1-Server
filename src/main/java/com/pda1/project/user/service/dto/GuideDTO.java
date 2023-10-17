package com.pda1.project.user.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuideDTO {

    @JsonProperty("type")
    private String type;

    @JsonProperty("question")
    private String question;

    @JsonProperty("description")
    private String description;

}
