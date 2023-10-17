package com.pda1.project.user.controller.request;

import com.pda1.project.user.service.dto.ChatbotRequestDTO;
import com.pda1.project.user.service.dto.UserFilterDTO;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatbotRequest {

    private String type;
    private String question;

    public ChatbotRequestDTO toServiceDto(){
        return ChatbotRequestDTO.of(type, question);
    }
}
