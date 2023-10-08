package com.pda1.project.domain.UserInformation;

import com.pda1.project.domain.BaseTimeEntity;
import com.pda1.project.domain.Evaluation.Evaluation;
import com.pda1.project.domain.InterestItem.InterestItem;
import com.pda1.project.domain.survey.Survey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserInformation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String name;
    private String email;
    private String account;
    private String password;

    @OneToOne
    @JoinColumn(name = "survey_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Survey survey;

    @OneToMany(mappedBy = "userInformation", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<InterestItem> interestItems = new ArrayList<>();

    @OneToMany(mappedBy = "userInformation", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Evaluation> evaluations = new ArrayList<>();
}
