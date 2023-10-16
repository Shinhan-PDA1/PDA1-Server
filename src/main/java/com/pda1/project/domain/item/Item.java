package com.pda1.project.domain.item;

import com.pda1.project.domain.BaseTimeEntity;
import com.pda1.project.domain.InterestItem.InterestItem;
import com.pda1.project.domain.ItemValue.ItemValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column
    private String theme;

    @OneToMany(mappedBy = "item", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<InterestItem> interestItems = new ArrayList<>();

    @OneToMany(mappedBy = "item", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ItemValue> interestValues = new ArrayList<>();
}
