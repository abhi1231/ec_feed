package com.ec.dao;

import com.ec.entity.CategoryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryItem extends JpaRepository<CategoryItemEntity,String> {
}
