package com.example.pichinchatest.catergories;

import com.example.pichinchatest.catergories.model.Category;
import com.example.pichinchatest.catergories.repository.CategoriesRepository;
import com.example.pichinchatest.catergories.representation.*;
import com.example.pichinchatest.items.model.Items;
import com.example.pichinchatest.items.model.ItemsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoriesController implements CategoriesApi{

    private final CategoriesService categoriesService;
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesController(CategoriesService categoriesService, CategoriesRepository categoriesRepository) {
        this.categoriesService = categoriesService;
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public CreateCategoryRequest addCategory(CreateCategoryRequest request) {
        return categoriesService.createNewCategory(request);
    }

    @Override
    public RetrieveItemsPerCategoryResponse retrieveItemsInCategory(long id) {
        if(!categoriesRepository.findById(id).isPresent()){
            throw new RuntimeException("Category Id not exist", new Exception());
        }
        Category category = categoriesRepository.findById(id).get();
        List<Items> itemsList = category.getListItemsRecord()
                .stream()
                .filter(ItemsRecord::isIntoCategory)
                .map(ItemsRecord::getItems)
                .collect(Collectors.toList());
        return RetrieveItemsPerCategoryResponse.builder()
                .categoryId(category.getId())
                .categoryName(category.getCategoryName())
                .itemsList(itemsList)
                .build();
    }

    @Override
    public RetrieveAllInfoPerCategoryResponse retrieveAllInfoInCategory(long id) {
        if(!categoriesRepository.findById(id).isPresent()){
            throw new RuntimeException("Category Id not exist", new Exception());
        }
        Category category = categoriesRepository.findById(id).get();
        List<ItemsInCategoryResponse> itemsList = category.getListItemsRecord()
                .stream()
                .map(response -> ItemsInCategoryResponse.builder()
                        .isIntoCategory(response.isIntoCategory())
                        .items(response.getItems())
                        .build())
                .collect(Collectors.toList());
        return RetrieveAllInfoPerCategoryResponse.builder()
                .categoryId(category.getId())
                .categoryName(category.getCategoryName())
                .itemsInformationList(itemsList)
                .build();
    }

}
