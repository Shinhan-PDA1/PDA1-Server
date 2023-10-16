package com.pda1.project.domain.InterestItem;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pda1.project.domain.BaseTimeEntity;
import com.pda1.project.domain.UserInformation.UserInformation;
import com.pda1.project.domain.item.Item;
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
public class InterestItem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserInformation userInformation;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

}
