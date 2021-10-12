package com.example.pichinchatest.items.repository;

import com.example.pichinchatest.items.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemsRepository extends JpaRepository<Items, Long> {

    Optional<Items> findById(Long id);

}