package com.pda1.project.user.service;


import com.pda1.project.user.controller.Response.MainChatbotResponse;
import com.pda1.project.user.controller.Response.MainDetailResponse;
import com.pda1.project.user.service.dto.ChatbotRequestDTO;
import com.pda1.project.user.service.dto.UserFilterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class InfoConnectorUriRequestService {

    public final InfoConnectorUriBuilderService uriBuilderService;

    public MainDetailResponse getDetailInformation(String stockCode) {
        URI uri = uriBuilderService.buildDetailUri(stockCode);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, MainDetailResponse.class).getBody();
    }

    public MainChatbotResponse saveConversationAndGetAnswer(ChatbotRequestDTO data, Long userId) {

        URI uri = uriBuilderService.buildChatbotUri();

        String jsonRequest =
                "{ " + "\"type\" : " + "\"" + data.getType() + "\", "
                    + "\"question\" : " + "\"" + data.getQuestion() + "\", "
                    + "\"userId\" : " + "\"" + userId + "\" " + "}";

        System.out.println(jsonRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity httpEntity = new HttpEntity<>(jsonRequest, headers);

        return new RestTemplate().exchange(uri, HttpMethod.POST, httpEntity, MainChatbotResponse.class).getBody();

    }
}
