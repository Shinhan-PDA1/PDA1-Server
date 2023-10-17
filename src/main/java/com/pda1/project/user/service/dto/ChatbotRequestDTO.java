package com.pda1.project.user.service.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatbotRequestDTO {

    private String type;
    private String question;

    public static ChatbotRequestDTO of(String type, String question){
        return new ChatbotRequestDTO(type, question);
    }
}
