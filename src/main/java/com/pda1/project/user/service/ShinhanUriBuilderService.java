package com.pda1.project.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class ShinhanUriBuilderService {
    private static final String PORTFOLIO_RECOMMEND_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/recommend/portfolio";
    private static final String POPULAR_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/ranking/rising";
    private static final String ISSUE_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/ranking/issue";
    private static final String STRATEGY_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/strategy/invest";
    private static final String MARKET_ISSUE_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/strategy/market-issue";


    public URI buildRecommendPortfolioUri() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(PORTFOLIO_RECOMMEND_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }
    public URI buildPopularUri() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(POPULAR_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }

    public URI buildIssueUri(String query) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(ISSUE_URL);
        uriBuilder.queryParam("query_type", query);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;

    }

    public URI buildStrategyUri() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(STRATEGY_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }

    public URI buildMarketUri() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(MARKET_ISSUE_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }
}
