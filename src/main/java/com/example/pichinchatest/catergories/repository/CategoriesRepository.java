package com.example.pichinchatest.catergories.repository;

import com.example.pichinchatest.catergories.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Long> {

}