package com.ec.controller;


import com.ec.entity.Product1;
import com.ec.service.product1.Product1ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value ="/api/product1")
public class Product1Controller {

    @Autowired
    private Product1ServiceImpl product1ServiceImpl;


    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = product1ServiceImpl.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }
    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImageAndData(
            @RequestParam("image") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("description") String description
    ) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Image file is required.");
        }

        byte[] imageData = file.getBytes();
        Product1 product = new Product1();
        product.setName(name);
        product.setImage(imageData);
        product.setPrice(price);
        product.setDescription(description);
        product1ServiceImpl.saveProduct(product);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Image and data uploaded successfully.");
    }

    @PutMapping
    public ResponseEntity<String> uploadImageAndData(
            @RequestParam(value = "productId", required = false,defaultValue = "-1") int productId,
            @RequestParam("image") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("description") String description
    ) throws IOException {
        if (productId != -1) {
            // ProductId is provided, so we want to update the existing product
            Product1 existingProduct = product1ServiceImpl.getProductById(productId);
            if (existingProduct == null) {
                return ResponseEntity.notFound().build();
            }

            if (!file.isEmpty()) {
                byte[] imageData = file.getBytes();
                existingProduct.setImage(imageData);
            }

            existingProduct.setName(name);
            existingProduct.setPrice(price);
            existingProduct.setDescription(description);
            product1ServiceImpl.saveProduct(existingProduct);
        } else {
            // ProductId is not provided, so we want to create a new product
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Image file is required.");
            }

            byte[] imageData = file.getBytes();
            Product1 newProduct = new Product1();
            newProduct.setName(name);
            newProduct.setImage(imageData);
            newProduct.setPrice(price);
            newProduct.setDescription(description);
            product1ServiceImpl.saveProduct(newProduct);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body("Image and data uploaded successfully.");
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Product1>> getAllProducts() {
        List<Product1> productList = product1ServiceImpl.getAllProducts();


        return ResponseEntity.ok(productList);
    }
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
        Product1 existingProduct = product1ServiceImpl.getProductById(productId);
        product1ServiceImpl.deleteProduct(existingProduct);
        return ResponseEntity.ok("Product deleted successfully.");
    }
}
