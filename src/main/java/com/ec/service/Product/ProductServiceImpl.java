package com.ec.service.Product;

import com.ec.dao.ProductDao;
import com.ec.entity.ProductEntity;
import com.ec.service.Cart.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl  {
//
//    @Autowired
//    private ProductDao productDao;
//
//
//    @Override
//    public ProductEntity saveProduct(ProductEntity product, MultipartFile imageFile) {
//        try {
//            byte[] imageBytes = imageFile.getBytes();
//            product.setImage(imageBytes);
//            return productDao.save(product);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
////    @Override
////    public ProductEntity updateProductImg(Long productId, ProductEntity product, MultipartFile imageFile) {
////        ProductEntity existingProduct = productDao.findById(productId).orElse(null);
////        if (existingProduct != null) {
////            existingProduct.setName(product.getName());
////            existingProduct.setDescription(product.getDescription());
////            existingProduct.setPrice(product.getPrice());
////
////            try {
////                byte[] imageBytes = imageFile.getBytes();
////                existingProduct.setImage(imageBytes);
////            } catch (Exception e) {
////               e.printStackTrace();
////            }
////
////            return productDao.save(existingProduct);
////        }
////        return null;
////    }
////    @Override
////    public ProductEntity updateProductImg(Long productId, ProductEntity product, MultipartFile imageFile) {
////        ProductEntity existingProduct = productDao.findById(productId).orElse(null);
////        if (existingProduct != null) {
////            existingProduct.setName(product.getName());
////            existingProduct.setDescription(product.getDescription());
////            existingProduct.setPrice(product.getPrice());
////
//////            if (imageFile != null && !imageFile.isEmpty()) {
////                try {
////                    byte[] imageBytes = imageFile.getBytes();
////                    existingProduct.setImage(imageBytes);
////                } catch (IOException e) {
////                    e.printStackTrace();
////
////                }
//////            }
////
////            return productDao.save(existingProduct);
////        }
////        return null;
////    }
//
//    // only for images
//    @Override
//    public ProductEntity updateProductImage(Long productId, MultipartFile imageFile) {
//        ProductEntity existingProduct = productDao.findById(productId).orElse(null);
//
//        try {
//            byte[] imageBytes = imageFile.getBytes();
//            existingProduct.setImage(imageBytes);
//            return productDao.save(existingProduct);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//    @Override
//    public List<ProductEntity> getAllProducts() {
//        return productDao.findAll();
//    }
//
//    @Override
//    public Optional<ProductEntity> getProductById(Long productId) {
//        return productDao.findById(productId);
//    }
//
//    @Override
//    public ProductEntity createProduct(ProductEntity product) {
//
//        return productDao.save(product);
//    }
//
//    @Override
//    public ProductEntity updateProduct(Long productId, ProductEntity updatedProduct) {
//
//        return productDao.save(updatedProduct);
//    }
//
//    @Override
//    public void deleteProduct(Long productId) {
//        productDao.deleteById(productId);
//    }
}
