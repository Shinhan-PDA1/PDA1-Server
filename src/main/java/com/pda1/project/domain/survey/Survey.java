package com.pda1.project.domain.survey;

import com.pda1.project.domain.BaseTimeEntity;
import com.pda1.project.domain.UserInformation.UserInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Survey extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surveyId;

    @Column
    private String investExperience;
    private String age;
    private String investPeriod;
    private String revenueTrend;

    @OneToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserInformation userInformation;

}
