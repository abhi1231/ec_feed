package com.ec.service.product1;

import com.ec.dao.ProductDao;
import com.ec.entity.Product1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class Product1ServiceImpl implements Product1Service {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product1 addProduct(Product1 product1) {

        return productDao.save(product1);
    }

    public String uploadImage(MultipartFile file) throws IOException {

        Product1 imageData = productDao.save(Product1.builder()
                .name(file.getOriginalFilename())
                .description(file.getContentType())
                .image(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public Product1 saveProduct(Product1 product) {
        return productDao.save(product);
    }

    @Override
    public Product1 getProductById(int productId) {
        return productDao.findById(productId).orElse(null);
    }

    @Override
    public List<Product1> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public void deleteProduct(Product1 product) {
        productDao.delete(product);
    }
}
