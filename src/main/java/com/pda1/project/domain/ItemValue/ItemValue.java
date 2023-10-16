package com.pda1.project.domain.ItemValue;

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
public class ItemValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long valueId;

    @Column
    private String itemName;
    private String currPrice;
    private String changeNumber;
    private String changeRate;
    private String stockCode;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;
}
