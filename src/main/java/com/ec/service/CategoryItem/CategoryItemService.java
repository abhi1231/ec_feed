package com.ec.service.CategoryItem;

import com.ec.entity.CategoryItemEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryItemService {

    List<CategoryItemEntity> getAllCategories();

    Optional<CategoryItemEntity> getCategoryById(String categoryId);

    CategoryItemEntity createCategory(CategoryItemEntity category);

    CategoryItemEntity updateCategory(String categoryId, CategoryItemEntity category);

    void deleteCategory(String categoryId);
}
