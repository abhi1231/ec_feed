package com.ec.service.CategoryItem;

import com.ec.dao.CategoryItem;
import com.ec.entity.CategoryItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryItemServiceImpl implements CategoryItemService{


    @Autowired
    private CategoryItem categoryItem;
    @Override
    public List<CategoryItemEntity> getAllCategories() {
        return categoryItem.findAll();
    }

    @Override
    public Optional<CategoryItemEntity> getCategoryById(String categoryId) {
        return categoryItem.findById(categoryId);
    }

    @Override
    public CategoryItemEntity createCategory(CategoryItemEntity category) {
        return categoryItem.save(category);
    }

    @Override
    public CategoryItemEntity updateCategory(String categoryId, CategoryItemEntity category) {

       // Optional<CategoryItemEntity> catItemOld = categoryItem.findById(categoryId);

        return categoryItem.save(category);
    }

    @Override
    public void deleteCategory(String categoryId) {
        categoryItem.deleteById(categoryId);

    }
}