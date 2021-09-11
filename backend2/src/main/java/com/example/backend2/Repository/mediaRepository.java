package com.example.backend2.Repository;

import com.example.backend2.Entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface mediaRepository extends JpaRepository<Media,Long> {
    @Override
    List<Media> findAll();
}
