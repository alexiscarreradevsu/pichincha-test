package com.example.pichinchatest.catergories;

import com.example.pichinchatest.catergories.representation.CreateCategoryRequest;
import com.example.pichinchatest.catergories.representation.RetrieveAllInfoPerCategoryResponse;
import com.example.pichinchatest.catergories.representation.RetrieveItemsPerCategoryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface CategoriesApi {

    @PostMapping(value = "/category",
            produces = {"application/json"},
            consumes = {"application/json"})
    CreateCategoryRequest addCategory(@Valid @RequestBody CreateCategoryRequest request);


    @GetMapping(value = "/itemspercategory/{categoryId}",
            produces = {"application/json"},
            consumes = {"application/json"})
    RetrieveItemsPerCategoryResponse retrieveItemsInCategory(@PathVariable("categoryId") long id);

    @GetMapping(value = "/allinfocategory/{categoryId}",
            produces = {"application/json"},
            consumes = {"application/json"})
    RetrieveAllInfoPerCategoryResponse retrieveAllInfoInCategory(@PathVariable("categoryId") long id);

}
