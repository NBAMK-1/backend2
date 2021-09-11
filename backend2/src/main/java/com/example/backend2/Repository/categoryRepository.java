package com.example.backend2.Repository;

import com.example.backend2.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface categoryRepository extends JpaRepository<Category,Long> {
    @Override
     List<Category> findAll();
}