package com.ec.controller;

import com.ec.entity.CartEntity;
import com.ec.entity.CategoryItemEntity;
import com.ec.entity.Customer;
import com.ec.service.CategoryItem.CategoryItemService;
import com.ec.service.CategoryItem.CategoryItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryItemController {

    @Autowired
    private CategoryItemServiceImpl categoryItemServiceImpl;

    @GetMapping
    public List<CategoryItemEntity> getAllCategories() {
        return categoryItemServiceImpl.getAllCategories();
    }



    @GetMapping("/{categoryId}")
    public Optional<CategoryItemEntity> getAllCarts(@PathVariable("categoryId") String category_id) {
        return categoryItemServiceImpl.getCategoryById(category_id);
    }
    @PostMapping
    public CategoryItemEntity createCategory(@RequestBody CategoryItemEntity category) {

        return categoryItemServiceImpl.createCategory(category) ;
    }

    @PutMapping("/{categoryId}")
    public CategoryItemEntity updateCategory(@PathVariable("categoryId") String categoryId, @RequestBody CategoryItemEntity category) {

        return categoryItemServiceImpl.updateCategory(categoryId, category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") String categoryId) {
        categoryItemServiceImpl.deleteCategory(categoryId);
    }
}
