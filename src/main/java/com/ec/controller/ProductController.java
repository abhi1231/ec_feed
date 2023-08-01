package com.ec.controller;


import com.ec.entity.ProductEntity;
import com.ec.service.Product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

//    @PostMapping(value = "/createimg")
//    public ResponseEntity<ProductEntity> createProduct(@ModelAttribute ProductEntity product,
//                                                       @RequestParam("imageFile") MultipartFile imageFile) {
//        ProductEntity savedProduct = productServiceImpl.saveProduct(product, imageFile);
//        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
//    }
//
//    //    @PutMapping("/{productId1}")
////    @PutMapping(value = "/image/{productId}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE })
////    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long productId,
////                                                       @RequestBody ProductEntity product,
////                                                       @RequestParam(value = "imageFile", required = false) MultipartFile imageFile){
////        ProductEntity updatedProduct = productServiceImpl.updateProductImg(productId, product, imageFile);
////        if (updatedProduct != null) {
////            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
////        } else {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////    }
//
////    @PutMapping(value = "/image/{productId}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE })
////    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long productId,
////                                                       @RequestPart(required = false) MultipartFile imageFile,
////                                                       @RequestPart ProductEntity product) {
////        ProductEntity updatedProduct = productServiceImpl.updateProductImg(productId, product, imageFile);
////        if (updatedProduct != null) {
////            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
////        } else {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////    }
//
//    @PutMapping(value = "/image/{productId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<ProductEntity> updateProductImage(@PathVariable Long productId,
//                                                            @RequestParam(value = "image",required = false) MultipartFile imageFile) {
//        ProductEntity updatedProduct = productServiceImpl.updateProductImage(productId, imageFile);
//        if (updatedProduct != null) {
//            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @GetMapping
//    public ResponseEntity<List<ProductEntity>> getAllProducts() {
//        List<ProductEntity> products = productServiceImpl.getAllProducts();
//        return ResponseEntity.ok().body(products);
//    }
//
//    @GetMapping("/{productId}")
//    public ResponseEntity<Optional<ProductEntity>> getProductById(@PathVariable("productId") Long productId) {
//        Optional<ProductEntity> product = productServiceImpl.getProductById(productId);
//        if (product != null) {
//            return ResponseEntity.ok().body(product);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//        @PostMapping
//        public ResponseEntity<ProductEntity> createProduct (@RequestBody ProductEntity product){
//            ProductEntity createdProduct = productServiceImpl.createProduct(product);
//            return ResponseEntity.ok().body(createdProduct);
//        }
////
////        @PutMapping("/{productId}")
////        public ResponseEntity<ProductEntity> updateProduct (@PathVariable("productId") Long
////        productId, @RequestBody ProductEntity product){
////            ProductEntity updatedProduct = productServiceImpl.updateProduct(productId, product);
////            if (updatedProduct != null) {
////                return ResponseEntity.ok().body(updatedProduct);
////            } else {
////                return ResponseEntity.notFound().build();
////            }
////        }
////
//        @DeleteMapping("/{productId}")
//        public void deleteProduct (@PathVariable("productId") Long productId){
//            productServiceImpl.deleteProduct(productId);
//        }
    }

