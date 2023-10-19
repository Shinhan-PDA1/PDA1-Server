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
    private static final String DETAIL_INFO_URL =  "jootopia-infoconnector-service.team-1.svc.cluster.local/api/v1/zootopia/detail";
    private static final String CHATBOT_URL =  "jootopia-infoconnector-service.team-1.svc.cluster.local/api/v1/openai/chatbot";
    private static final String GUIDE_URL =  "jootopia-infoconnector-service.team-1.svc.cluster.local/api/v1/zootopia/guide";
    private static final String STOCK_CODE_URL =  "jootopia-infoconnector-service.team-1.svc.cluster.local/api/v1/zootopia/search";


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

    public URI buildGuideUri(Long userId) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(GUIDE_URL);
        uriBuilder.queryParam("userId", userId);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }

    public URI buildStockCodeUri(String query) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(STOCK_CODE_URL);
        uriBuilder.queryParam("stockName", query);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }
}
