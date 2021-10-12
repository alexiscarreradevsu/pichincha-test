package com.example.pichinchatest.category;

import com.example.pichinchatest.catergories.CategoriesController;
import com.example.pichinchatest.catergories.CategoriesService;
import com.example.pichinchatest.catergories.repository.CategoriesRepository;
import com.example.pichinchatest.catergories.representation.CreateCategoryRequest;
import com.example.pichinchatest.test.TestDataGeneratorUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CategoryApiServiceTest {

    @MockBean
    private CategoriesService categoriesService;
    @MockBean
    private CategoriesRepository categoriesRepository;

    private CategoriesController categoriesController;

    @Before
    public void setUp() {
        categoriesController = new CategoriesController(categoriesService, categoriesRepository);
    }

    @Test
    public void addCategory_shouldCallCategoryService() {
        CreateCategoryRequest createCategoryRequest = TestDataGeneratorUtil.generateCreateCategoryRequest();
        when(categoriesService.createNewCategory(createCategoryRequest)).thenReturn(createCategoryRequest);
        categoriesController.addCategory(createCategoryRequest);
        verify(categoriesService).createNewCategory(createCategoryRequest);
    }


}
