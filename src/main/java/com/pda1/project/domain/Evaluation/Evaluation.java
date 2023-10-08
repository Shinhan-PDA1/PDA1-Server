package com.pda1.project.domain.Evaluation;

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
public class Evaluation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evaluationId;

    private double satisfaction;

}
