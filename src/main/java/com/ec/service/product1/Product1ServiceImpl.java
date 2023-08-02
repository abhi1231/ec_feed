package com.ec.service.product1;

import com.ec.dao.CartDao;
import com.ec.dao.CategoryItem;
import com.ec.dao.ProductDao;
import com.ec.dto.ProductRequestDTO;
import com.ec.entity.CartEntity;
import com.ec.entity.CategoryItemEntity;
import com.ec.entity.Product1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class Product1ServiceImpl implements Product1Service {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryItem categoryItem;

    @Autowired
    private CartDao cartDao;

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
    //  New add

    public Product1 createProduct(ProductRequestDTO productRequestDTO) {
        Product1 product = new Product1();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setImage(productRequestDTO.getImage());
      //  product.setCreatedAt(LocalDateTime.now());
       // product.setUpdatedAt(LocalDateTime.now());

        Long categoryId = productRequestDTO.getCategoryId();
        if (categoryId != null) {
            Optional<CategoryItemEntity> optionalCategory = categoryItem.findById(categoryId);
            if (optionalCategory.isPresent()) {
                product.setCategoryItemEntity(optionalCategory.get());
            } else {
                throw new IllegalArgumentException("Invalid categoryId");
            }
        }

        Long cartId = productRequestDTO.getCartId();
        if (cartId != null) {
            Optional<CartEntity> optionalCart = cartDao.findById(cartId);
            if (optionalCart.isPresent()) {
                product.setCartEntity(optionalCart.get());
            } else {
                throw new IllegalArgumentException("Invalid cartId");
            }
        }

        return productDao.save(product);
    }


}
