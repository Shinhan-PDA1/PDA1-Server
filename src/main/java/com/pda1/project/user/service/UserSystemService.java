package com.pda1.project.user.service;

import com.pda1.project.domain.InterestItem.InterestItem;
import com.pda1.project.domain.InterestItem.InterestItemRepository;
import com.pda1.project.domain.ItemValue.ItemValue;
import com.pda1.project.domain.ItemValue.ItemValueRepository;
import com.pda1.project.domain.UserInformation.UserInformation;
import com.pda1.project.domain.UserInformation.UserInformationRepository;
import com.pda1.project.domain.item.Item;
import com.pda1.project.domain.item.ItemRepository;
import com.pda1.project.domain.survey.Survey;
import com.pda1.project.domain.survey.SurveyRepository;
import com.pda1.project.user.controller.Response.InterestList;
import com.pda1.project.user.controller.Response.MainDetailResponse;
import com.pda1.project.user.controller.Response.MainInterestResponse;
import com.pda1.project.user.service.dto.ItemDTO;
import com.pda1.project.user.service.dto.UserFilterDTO;
import com.pda1.project.user.service.dto.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;

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
        System.out.println(principal.getName());

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


        return response;
    }

    public MainDetailResponse getDetailInformation(String stockCode) {

        MainDetailResponse response = infoConnectorUriRequestService.getDetailInformation(stockCode);

        return response;
    }
}
