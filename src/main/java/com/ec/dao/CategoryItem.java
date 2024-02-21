package com.ec.dao;

import com.ec.entity.CategoryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryItem extends JpaRepository<CategoryItemEntity,Long> {
}
