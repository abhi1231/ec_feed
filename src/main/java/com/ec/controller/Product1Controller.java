package com.ec.controller;


import com.ec.dao.CartDao;
import com.ec.dao.CategoryItem;
import com.ec.dao.ProductDao;
import com.ec.dto.ProductDto;
import com.ec.dto.ProductGetDto;
import com.ec.entity.CartEntity;
import com.ec.entity.CategoryItemEntity;
import com.ec.entity.Product1;
import com.ec.service.product1.Product1ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/getallWithId")
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
    @PostMapping(value = "/addNewProduct", consumes = {"multipart/form-data"})
    @ApiOperation(value = "Upload a product with an image")
    public ResponseEntity<String> uploadImageAndData(
            @RequestPart("image") MultipartFile file,
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

    // All product feild insert
    @PostMapping("/NewProduct")
    public ResponseEntity<String> uploadImageAndData(@ModelAttribute ProductDto productRequestDTO) throws IOException {
        if (productRequestDTO.getImage() == null || productRequestDTO.getImage().isEmpty()) {
            return ResponseEntity.badRequest().body("Image file is required.");
        }

        byte[] imageData = productRequestDTO.getImage().getBytes();
        Product1 product = new Product1();
        product.setName(productRequestDTO.getName());
        product.setImage(imageData);
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());

        // Optional: Set the cart and category based on their IDs
        if (productRequestDTO.getCartId() != null) {
            Optional<CartEntity> optionalCart = cartDao.findById(productRequestDTO.getCartId());
            if (optionalCart.isPresent()) {
                product.setCartEntity(optionalCart.get());
            } else {
                return ResponseEntity.badRequest().body("Invalid cartId.");
            }
        }

        if (productRequestDTO.getCategoryId() != null) {
            Optional<CategoryItemEntity> optionalCategory = categoryItem.findById(productRequestDTO.getCategoryId());
            if (optionalCategory.isPresent()) {
                product.setCategoryItemEntity(optionalCategory.get());
            } else {
                return ResponseEntity.badRequest().body("Invalid categoryId.");
            }
        }

        productDao.save(product);

        return ResponseEntity.status(HttpStatus.OK).body("Image and data uploaded successfully.");
    }


    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductGetDto> getProductById(@PathVariable int productId) {
        Product1 product = product1ServiceImpl.getProductByIdNew(productId);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        ProductGetDto productDto = product1ServiceImpl.mapProductToDto(product);

        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductGetDto>> getAllProductsNew1() {
        List<Product1> products = product1ServiceImpl.getAllProducts();

        // Map List of Product1 entities to List of ProductGetDto objects
        List<ProductGetDto> productDtos = product1ServiceImpl.mapProductsToDtoList(products);

        return ResponseEntity.ok(productDtos);
    }

}

