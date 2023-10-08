package com.pda1.project.domain.survey;

import com.pda1.project.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Survey extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surveyId;

    private int investmentPeriod;
    private String investmentType;

}
