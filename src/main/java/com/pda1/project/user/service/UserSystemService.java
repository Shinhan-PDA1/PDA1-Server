package com.pda1.project.user.service;

import com.pda1.project.domain.InterestItem.InterestItem;
import com.pda1.project.domain.InterestItem.InterestItemRepository;
import com.pda1.project.domain.ItemValue.ItemValue;
import com.pda1.project.domain.ItemValue.ItemValueRepository;
import com.pda1.project.domain.UserInformation.UserInformation;
import com.pda1.project.domain.UserInformation.UserInformationRepository;
import com.pda1.project.domain.item.ItemRepository;
import com.pda1.project.domain.survey.Survey;
import com.pda1.project.domain.survey.SurveyRepository;
import com.pda1.project.user.controller.Response.guide.MainGuideResponse;
import com.pda1.project.user.controller.Response.main.InterestList;
import com.pda1.project.user.controller.Response.chatbot.MainChatbotResponse;
import com.pda1.project.user.controller.Response.detail.MainDetailResponse;
import com.pda1.project.user.controller.Response.main.MainInterestResponse;
import com.pda1.project.user.service.dto.ChatbotRequestDTO;
import com.pda1.project.user.service.dto.ItemDTO;
import com.pda1.project.user.service.dto.UserFilterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class UserSystemService {

    private final UserInformationRepository userInformationRepository;
    private final SurveyRepository surveyRepository;
    private final InterestItemRepository interestItemRepository;
    private final ItemRepository itemRepository;
    private final ItemValueRepository itemValueRepository;

    private final InfoConnectorUriBuilderService infoConnectorUriBuilderService;
    private final InfoConnectorUriRequestService infoConnectorUriRequestService;

    public void saveFilterInfo(UserFilterDTO data, String account) {

        UserInformation userInformation = userInformationRepository.findByAccount(account).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        Survey survey = Survey.builder()
                                .age(data.getAge())
                                .investExperience(data.getInvestExperience())
                                .revenueTrend(data.getRevenueTrend())
                                .investPeriod(data.getInvestPeriod())
                                .userInformation(userInformation)
                                .build();

        surveyRepository.save(survey);

        data.getInterestTopic().stream().forEach(
                item -> interestItemRepository.save(InterestItem.builder()
                                                                .userInformation(userInformation)
                                                                .item(itemRepository.findByTheme(item).get())
                                                                .build())
        );

    }

    public MainInterestResponse getInterestItems(Principal principal) {

        MainInterestResponse response = new MainInterestResponse();
//        System.out.println(principal.getName());

        if(Objects.isNull(principal)){
            List<ItemDTO> itemDTOS = new ArrayList<>();

            List<ItemValue> itemValues = itemValueRepository.findAll();
            itemValues.stream().forEach(data -> itemDTOS.add(ItemDTO.builder()
                    .item_name(data.getItemName())
                    .change_number(data.getChangeNumber())
                    .change_rate(data.getChangeRate())
                    .curr_price(data.getCurrPrice())
                    .stock_code(data.getStockCode())
                    .build()));

            InterestList interestList = InterestList.builder()
                    .theme("종목")
                    .items(itemDTOS)
                    .build();

            response.getResponse().add(interestList);

        }
        else{
            UserInformation user = userInformationRepository.findByAccount(principal.getName()).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회원입니다."));

            List<InterestItem> items = interestItemRepository.findAllByUserInformation(user);

            for(InterestItem item : items){

                List<ItemDTO> itemDTOS = new ArrayList<>();

                List<ItemValue> itemValues = itemValueRepository.findAllByItem(item.getItem());
                itemValues.stream().forEach(data -> itemDTOS.add(ItemDTO.builder()
                        .item_name(data.getItemName())
                        .change_number(data.getChangeNumber())
                        .change_rate(data.getChangeRate())
                        .curr_price(data.getCurrPrice())
                        .stock_code(data.getStockCode())
                        .build()));

                InterestList interestList = InterestList.builder()
                        .theme(item.getItem().getTheme())
                        .items(itemDTOS)
                        .build();

                response.getResponse().add(interestList);
        }

        }

        return response;
    }

    public MainDetailResponse getDetailInformation(String stockCode) {

        MainDetailResponse response = infoConnectorUriRequestService.getDetailInformation(stockCode);

        return response;
    }

    public MainChatbotResponse saveConversationAndGetAnswer(ChatbotRequestDTO data, String account) {

        UserInformation user = userInformationRepository.findByAccount(account).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 유저입니다."));
        MainChatbotResponse response = infoConnectorUriRequestService.saveConversationAndGetAnswer(data, user.getUserId());

        return response;
    }

    public MainGuideResponse getGuideInformation(String account) {

        UserInformation user = userInformationRepository.findByAccount(account).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 유저입니다."));

        MainGuideResponse response = infoConnectorUriRequestService.getGuideInformation(user.getUserId());

        return response;
    }

    public String getStockCode(String query) {

        String pattern = "\\d{6}"; // 여섯 자리 숫자에 대한 정규 표현식
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(query);

        if (matcher.matches()) {
            // 입력 문자열이 여섯 자리 숫자인 경우 종목 코드로 분류
            return query;
        }
        else {
            // 그 외의 경우 종목명 으로 분류
            return infoConnectorUriRequestService.getStockCode(query);
        }

    }
}
