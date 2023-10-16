package com.pda1.project.user.service;


import com.pda1.project.user.controller.Response.MainDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
}
