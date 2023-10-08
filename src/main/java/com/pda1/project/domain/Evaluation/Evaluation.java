package com.pda1.project.domain.Evaluation;

import com.pda1.project.domain.BaseTimeEntity;
import com.pda1.project.domain.UserInformation.UserInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Evaluation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evaluationId;

    @Column
    private double satisfaction;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserInformation userInformation;
}
