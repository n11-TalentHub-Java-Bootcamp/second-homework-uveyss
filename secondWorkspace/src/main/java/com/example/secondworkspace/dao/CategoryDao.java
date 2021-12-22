package com.example.dao;

import com.example.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity,Long> {
   @Query("Select category From CategoryEntity category Order By category.categoryId desc" )
    List<CategoryEntity> findAll();

    Optional<CategoryEntity> findAllByCategoryId(long categoryId);
}
