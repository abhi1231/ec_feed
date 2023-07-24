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
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;

    @Autowired
    private ImageService imageService;



//    public ProductEntity saveProduct(ProductEntity product, MultipartFile imageFile) throws IOException {
//        if (imageFile != null && !imageFile.isEmpty()) {
//            String imageUrl = imageService.saveImage(imageFile);
//            product.setImageUrl(imageUrl);
//        }
//        return productDao.save(product);
//    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Optional<ProductEntity> getProductById(Long productId) {
        return productDao.findById(productId);
    }

    @Override
    public ProductEntity createProduct(ProductEntity product) {

        return productDao.save(product);
    }

    @Override
    public ProductEntity updateProduct(Long productId, ProductEntity updatedProduct) {

        return productDao.save(updatedProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        productDao.deleteById(productId);
    }
}
