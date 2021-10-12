package com.example.pichinchatest.items.repository;

import com.example.pichinchatest.catergories.model.Category;
import com.example.pichinchatest.items.model.Items;
import com.example.pichinchatest.items.model.ItemsRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemsRecordRepository extends JpaRepository<ItemsRecord, Long> {

    Optional<ItemsRecord> findByCategoryAndItems(Category category, Items items);

}