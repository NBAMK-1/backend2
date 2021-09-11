package com.example.backend2.Repository;

import com.example.backend2.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface articleRepository extends JpaRepository<Article, Long> {
    @Override
    List<Article> findAll();
}
