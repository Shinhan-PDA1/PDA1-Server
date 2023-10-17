package com.pda1.project.user.service;


import com.pda1.project.user.controller.Response.main.shinhan.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class ShinhanUriRequestService {

    public final ShinhanUriBuilderService uriBuilderService;

    public DataBodyResponse getPortfolio() {

        URI uri = uriBuilderService.buildRecommendPortfolioUri();

        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apiKey", "l7xxR7Fe0dP3i8KPZaPKpknI2vWrMeJfwDpk");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, DataBodyResponse.class).getBody();
    }

    public PopularResponse getPopular() {

        URI uri = uriBuilderService.buildPopularUri();

        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apiKey", "l7xxR7Fe0dP3i8KPZaPKpknI2vWrMeJfwDpk");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, PopularResponse.class).getBody();
    }

    public IssueResponse getIssue(String query) {
        URI uri = uriBuilderService.buildIssueUri(query);

        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apiKey", "l7xxR7Fe0dP3i8KPZaPKpknI2vWrMeJfwDpk");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, IssueResponse.class).getBody();
    }

    public StrategyResponse getStrategy() {
        URI uri = uriBuilderService.buildStrategyUri();

        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apiKey", "l7xxR7Fe0dP3i8KPZaPKpknI2vWrMeJfwDpk");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, StrategyResponse.class).getBody();
    }

    public MarketResponse getMarket() {
        URI uri = uriBuilderService.buildMarketUri();

        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apiKey", "l7xxR7Fe0dP3i8KPZaPKpknI2vWrMeJfwDpk");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, MarketResponse.class).getBody();
    }
}
