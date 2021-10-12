package com.example.pichinchatest.catergories;

import com.example.pichinchatest.catergories.model.Category;
import com.example.pichinchatest.catergories.repository.CategoriesRepository;
import com.example.pichinchatest.catergories.representation.CreateCategoryRequest;
import com.example.pichinchatest.catergories.representation.CreateCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public CreateCategoryResponse createNewCategory(CreateCategoryRequest categoryRequest){
        Category newCategory = Category.builder().categoryName(categoryRequest.getCategory()).build();
        categoriesRepository.save(newCategory);
        return CreateCategoryResponse.builder().category(categoryRequest.getCategory())
                .build();
    }

}
