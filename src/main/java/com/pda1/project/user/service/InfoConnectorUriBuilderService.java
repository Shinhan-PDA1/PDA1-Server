package com.pda1.project.user.service;

import com.pda1.project.user.service.dto.ChatbotRequestDTO;
import com.pda1.project.user.service.dto.UserFilterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class InfoConnectorUriBuilderService {
    private static final String DETAIL_INFO_URL =  "http://localhost:8080/api/v1/zootopia/detail";
    private static final String CHATBOT_URL =  "http://localhost:8080/api/v1/openai/chatbot";
    private static final String ISSUE_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/ranking/issue";
    private static final String STRATEGY_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/strategy/invest";
    private static final String MARKET_ISSUE_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/strategy/market-issue";



    public URI buildDetailUri(String stockCode) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(DETAIL_INFO_URL);
        uriBuilder.queryParam("code", stockCode);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }

    public URI buildChatbotUri() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(CHATBOT_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }
}
