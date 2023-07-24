package com.ec.controller;



import com.ec.entity.ProductEntity;
import com.ec.service.Product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;


//    @PostMapping(value = "/postwithimages")
//    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product,
//                                                       @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) throws IOException {
//        ProductEntity createdProduct = productServiceImpl.saveProduct(product, imageFile);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
//    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productServiceImpl.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<ProductEntity>> getProductById(@PathVariable("productId") Long productId) {
        Optional<ProductEntity> product = productServiceImpl.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        ProductEntity createdProduct = productServiceImpl.createProduct(product);
        return ResponseEntity.ok().body(createdProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductEntity product) {
        ProductEntity updatedProduct = productServiceImpl.updateProduct(productId, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok().body(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productServiceImpl.deleteProduct(productId);
    }
}
