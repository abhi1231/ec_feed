package com.ec.service.CategoryItem;

import com.ec.entity.CategoryItemEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryItemService {

    public List<CategoryItemEntity> getAllCategories();
    public CategoryItemEntity getCategoryById(Long id);
    public CategoryItemEntity createCategory(CategoryItemEntity category);
    public CategoryItemEntity updateCategory(Long id, CategoryItemEntity updatedCategory);
    public void deleteCategory(Long id);
}
