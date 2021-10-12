package com.example.pichinchatest.test;

import com.example.pichinchatest.catergories.representation.CreateCategoryRequest;

public class TestDataGeneratorUtil {

    public static CreateCategoryRequest generateCreateCategoryRequest() {
        return CreateCategoryRequest.builder()
                .category("category1")
                .build();
    }

}
