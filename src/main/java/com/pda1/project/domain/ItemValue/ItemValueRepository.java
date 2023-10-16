package com.pda1.project.domain.ItemValue;

import com.pda1.project.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemValueRepository extends JpaRepository<ItemValue, Long> {
    List<ItemValue> findAllByItem(Item item);
}
