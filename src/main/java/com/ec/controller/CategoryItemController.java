package com.ec.controller;

import com.ec.dto.CategoryRequestDTO;
import com.ec.entity.CartEntity;
import com.ec.entity.CategoryItemEntity;
import com.ec.entity.Customer;
import com.ec.service.CategoryItem.CategoryItemService;
import com.ec.service.CategoryItem.CategoryItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryItemController {

    @Autowired
    private CategoryItemServiceImpl categoryItemServiceImpl;

    @GetMapping("/getAll")
    public List<CategoryItemEntity> getAllCategories() {
        return categoryItemServiceImpl.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryItemEntity getCategoryById(@PathVariable Long id) {
        return categoryItemServiceImpl.getCategoryById(id);
    }


    @PostMapping
    public ResponseEntity<CategoryItemEntity> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        try {
            CategoryItemEntity savedCategory = categoryItemServiceImpl.createCategory(categoryRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryItemEntity> updateCategory(
            @PathVariable Long categoryId,
            @RequestBody CategoryRequestDTO categoryRequestDTO
    ) {
        try {
            CategoryItemEntity updatedCategory = categoryItemServiceImpl.updateCategory(categoryId, categoryRequestDTO);
            return ResponseEntity.ok(updatedCategory);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }



    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryItemServiceImpl.deleteCategory(id);
    }


}
