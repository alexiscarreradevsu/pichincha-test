package com.example.pichinchatest.catergories.repository;

import com.example.pichinchatest.catergories.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long id);

}