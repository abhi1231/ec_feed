package com.ec.service.product1;

import com.ec.entity.Product1;

import java.util.List;

public interface Product1Service {

   public Product1 addProduct(Product1 product1);
   public Product1 getProductById(int productId);

   public List<Product1> getAllProducts();

   public void deleteProduct(Product1 product);
}
