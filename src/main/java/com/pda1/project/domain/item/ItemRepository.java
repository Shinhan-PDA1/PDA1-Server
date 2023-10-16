package com.pda1.project.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {
//    Optional<Item> findByItemName(String item);

//    List<Item> findAllByTheme(String theme);

    Optional<Item> findByTheme(String item);
}
