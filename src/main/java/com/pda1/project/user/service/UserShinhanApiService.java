package com.pda1.project.user.service;

import com.pda1.project.user.controller.Response.main.shinhan.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserShinhanApiService {

    private final ShinhanUriRequestService uriRequestService;
    public List<MainPortfolioResponse> getPortfolio() {

        List<MainPortfolioResponse> mainResponse = new ArrayList<>();

        DataBodyResponse response = uriRequestService.getPortfolio();

        response.getDataBody().getList().stream().forEach(
                data -> mainResponse.add(
                        MainPortfolioResponse.builder()
                                .stock_code(data.getStock_code())
                                .stock_name(data.getStbd_name())
                                .revenue_rate(data.getReve_rt())
                                .transfer_date(data.getIncp_ymd())
                                .transfer_price(data.getIncp_prc())
                                .build()
                )
        );

        return mainResponse;
    }

    public List<MainPopularResponse> getPopular() {

        List<MainPopularResponse> mainResponse = new ArrayList<>();

        PopularResponse response = uriRequestService.getPopular();

        response.getPopularDataBody().getList().stream().forEach(
                data -> mainResponse.add(
                        MainPopularResponse.builder()
                                .stock_code(data.getStockCode())
                                .stock_name(data.getStockName())
                                .category(data.getCategory())
                                .count(data.getCount())
                                .ranking(data.getRanking())
                                .variable_ranking(data.getVariableRanking())
                                .build()
                )
        );

        return mainResponse;
    }

    public List<MainIssueResponse> getIssue(String query) {

        List<MainIssueResponse> mainResponse = new ArrayList<>();

        IssueResponse response = uriRequestService.getIssue(query);

        response.getList().stream().forEach(
                data -> mainResponse.add(
                        MainIssueResponse.builder()
                                .stock_code(data.getStockCode())
                                .stock_name(data.getStockName())
                                .rank(data.getRank())
                                .build()
                )
        );

        return mainResponse;
    }

    public List<MainStrategyResponse> getStrategy() {

        List<MainStrategyResponse> mainResponse = new ArrayList<>();

        StrategyResponse response = uriRequestService.getStrategy();

        response.getStrategyDataBody().getList().stream().forEach(
                data -> mainResponse.add(
                        MainStrategyResponse.builder()
                                .date(data.getDate())
                                .name(data.getName())
                                .title(data.getTitle())
                                .url(data.getUrl())
                                .build()
                )
        );

        return mainResponse;

    }

    public List<MainMarketResponse> getMarketIssue() {

        List<MainMarketResponse> mainResponse = new ArrayList<>();

        MarketResponse response = uriRequestService.getMarket();

        response.getMarketDataBody().getList().stream().forEach(
                data -> mainResponse.add(
                        MainMarketResponse.builder()
                                .date(data.getDate())
                                .name(data.getName())
                                .content(data.getContent())
                                .url(data.getUrl())
                                .build()
                )
        );

        return mainResponse;

    }
}
