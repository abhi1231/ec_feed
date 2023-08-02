package com.ec.controller;


import com.ec.dao.CartDao;
import com.ec.dao.CategoryItem;
import com.ec.dao.ProductDao;
import com.ec.entity.Product1;
import com.ec.service.product1.Product1ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product1")
public class Product1Controller {

    @Autowired
    private Product1ServiceImpl product1ServiceImpl;
    @Autowired
    private CategoryItem categoryItem;

    @Autowired
    private CartDao cartDao;
    @Autowired
    private ProductDao productDao;


    @PutMapping
    public ResponseEntity<String> uploadImageAndData(
            @RequestParam(value = "productId", required = false, defaultValue = "-1") int productId,
            @RequestParam("image") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("description") String description
    ) throws IOException {
        if (productId != -1) {
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

    //    @PostMapping
//    public ResponseEntity<Product1> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
//        try {
//            Product1 savedProduct = product1ServiceImpl.createProduct(productRequestDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
    @PostMapping("/addNewProduct")
    public ResponseEntity<String> uploadImageAndData(
            @RequestParam("image") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("description") String description
            //  @RequestParam("cartId") long cartId,
            // @RequestParam("categoryId") long categoryId
            //  @RequestParam("data") ProductRequestDTO productRequestDTO
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
        product.setImage(imageData);
        productDao.save(product);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Image and data uploaded successfully.");
    }
}

