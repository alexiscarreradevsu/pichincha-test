package com.example.pichinchatest.test;

import com.example.pichinchatest.catergories.model.Category;
import com.example.pichinchatest.catergories.representation.CreateCategoryRequest;
import com.example.pichinchatest.items.model.Items;
import com.example.pichinchatest.items.model.ItemsRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestDataGeneratorUtil {

    public static CreateCategoryRequest generateCreateCategoryRequest() {
        return CreateCategoryRequest.builder()
                .category("category1")
                .build();
    }


    public static Category generateCategoryCompleteModel() {
        return Category.builder()
                .id(1L)
                .categoryName("category1")
                .listItemsRecord( new ArrayList<ItemsRecord>() {{
                    add(generateItemsRecordModel());
                    add(generateItemsRecordModel2());
                }})
                .build();
    }

    public static Category generateCategoryModel() {
        return Category.builder()
                .id(1L)
                .categoryName("category1")
                .build();
    }

    public static ItemsRecord generateItemsRecordModel() {
        return ItemsRecord.builder()
                .id(1L)
                .isIntoCategory(true)
                .items(generateItemsModel1())
                .category(generateCategoryModel())
                .build();
    }

    public static ItemsRecord generateItemsRecordModel2() {
        return ItemsRecord.builder()
                .id(2L)
                .isIntoCategory(true)
                .items(generateItemsModel2())
                .category(generateCategoryModel())
                .build();
    }

    public static Items generateItemsModel1() {
        return Items.builder()
                .id(1L)
                .name("Item1")
                .type("Type1")
                .build();
    }

    public static Items generateItemsModel2() {
        return Items.builder()
                .id(2L)
                .name("Item2")
                .type("Type2")
                .build();
    }

}
