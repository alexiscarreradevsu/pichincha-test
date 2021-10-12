package com.example.pichinchatest.category;

import com.example.pichinchatest.catergories.CategoriesController;
import com.example.pichinchatest.catergories.CategoriesService;
import com.example.pichinchatest.catergories.model.Category;
import com.example.pichinchatest.catergories.repository.CategoriesRepository;
import com.example.pichinchatest.test.TestDataGeneratorUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

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
        Category category = TestDataGeneratorUtil.generateCategoryCompleteModel();
        Mockito.when(categoriesRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(category));
        categoriesController.retrieveItemsInCategory(1L);
        verify(categoriesController).retrieveItemsInCategory(category.getId());
    }


}
