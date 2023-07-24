package com.ec.service.Product;

import com.ec.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAllProducts();

    Optional<ProductEntity> getProductById(Long productId);

    ProductEntity createProduct(ProductEntity product);

    ProductEntity updateProduct(Long productId, ProductEntity product);

   void deleteProduct(Long productId);
}
