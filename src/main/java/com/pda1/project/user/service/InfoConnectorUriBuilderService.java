package com.pda1.project.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class InfoConnectorUriBuilderService {
    private static final String DETAIL_INFO_URL =  "http://localhost:8080/api/v1/zootopia/detail";
    private static final String POPULAR_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/ranking/rising";
    private static final String ISSUE_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/ranking/issue";
    private static final String STRATEGY_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/strategy/invest";
    private static final String MARKET_ISSUE_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/strategy/market-issue";



    public URI buildDetailUri(String stockCode) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(DETAIL_INFO_URL);
        uriBuilder.queryParam("code", stockCode);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }
}
