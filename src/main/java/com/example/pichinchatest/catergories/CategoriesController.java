package com.example.pichinchatest.catergories;

import com.example.pichinchatest.catergories.representation.CreateCategoryRequest;
import com.example.pichinchatest.catergories.representation.CreateCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesController implements CategoriesApi{

    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @Override
    public CreateCategoryResponse addCategory(CreateCategoryRequest request) {
        return categoriesService.createNewCategory(request);
    }

}
