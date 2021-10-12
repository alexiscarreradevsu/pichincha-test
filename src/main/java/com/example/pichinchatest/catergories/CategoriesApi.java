package com.example.pichinchatest.catergories;

import com.example.pichinchatest.catergories.representation.CreateCategoryRequest;
import com.example.pichinchatest.catergories.representation.CreateCategoryResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface CategoriesApi {

    @PostMapping(value = "/category",
            produces = {"application/json"},
            consumes = {"application/json"})
    CreateCategoryResponse addCategory(@Valid @RequestBody CreateCategoryRequest request);

}
