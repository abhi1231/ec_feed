package com.ec.service.Product;

import com.ec.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    //only for images
    ProductEntity updateProductImage(Long productId, MultipartFile imageFile);

    ProductEntity saveProduct(ProductEntity product, MultipartFile imageFile);
   // ProductEntity updateProductImg(Long productId, ProductEntity product, MultipartFile imageFile);

    List<ProductEntity> getAllProducts();

    Optional<ProductEntity> getProductById(Long productId);

    ProductEntity createProduct(ProductEntity product);

    ProductEntity updateProduct(Long productId, ProductEntity product);

   void deleteProduct(Long productId);
}
