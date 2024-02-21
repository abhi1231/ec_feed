package com.ec.service.CategoryItem;

import com.ec.dao.CategoryItem;
import com.ec.dao.ProductDao;
import com.ec.dto.CategoryRequestDTO;
import com.ec.entity.CategoryItemEntity;
import com.ec.entity.Product1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryItemServiceImpl implements CategoryItemService{


    @Autowired
    private CategoryItem categoryItem;

    @Autowired
    private ProductDao productDao;


    @Override
    public List<CategoryItemEntity> getAllCategories() {
        return categoryItem.findAll();
    }

    @Override
    public CategoryItemEntity getCategoryById(Long id) {
        return categoryItem.findById(id).orElse(null);
    }

    @Override
    public CategoryItemEntity createCategory(CategoryItemEntity category) {
        return categoryItem.save(category);
    }

    @Override
    public CategoryItemEntity updateCategory(Long id, CategoryItemEntity updatedCategory) {
        CategoryItemEntity existingCategory = categoryItem.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());
            existingCategory.setDescription(updatedCategory.getDescription());
            existingCategory.setCategory_id(updatedCategory.getCategory_id());
            return categoryItem.save(existingCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryItem.deleteById(id);
    }

    public CategoryItemEntity createCategory(CategoryRequestDTO categoryRequestDTO) {
        CategoryItemEntity category = new CategoryItemEntity();
        category.setName(categoryRequestDTO.getName());
        category.setDescription(categoryRequestDTO.getDescription());

        int productId = categoryRequestDTO.getProductId();
        if (productId != 0) {
            Optional<Product1> optionalProduct = productDao.findById(productId);
            if (optionalProduct.isPresent()) {
                category.setCategory_id(optionalProduct.get().getCategoryItemEntity().getCategory_id());
            } else {
                throw new IllegalArgumentException("Invalid productId");
            }
        }

        return categoryItem.save(category);
    }

    public CategoryItemEntity updateCategory(Long categoryId, CategoryRequestDTO categoryRequestDTO) {
        CategoryItemEntity existingCategory = categoryItem.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category not found"));

        existingCategory.setName(categoryRequestDTO.getName());
        existingCategory.setDescription(categoryRequestDTO.getDescription());

        int productId = categoryRequestDTO.getProductId();
        if (productId != 0) {
            Optional<Product1> optionalProduct = productDao.findById(productId);
            if (optionalProduct.isPresent()) {
                existingCategory.setCategory_id(optionalProduct.get().getCategoryItemEntity().getCategory_id());
            } else {
                throw new IllegalArgumentException("Invalid productId");
            }
        } else {
            existingCategory.setCategory_id(null);
        }

        return categoryItem.save(existingCategory);
    }
}