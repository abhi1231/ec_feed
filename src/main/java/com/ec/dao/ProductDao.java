package com.ec.dao;

import com.ec.entity.Product1;
import com.ec.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product1,Integer> {
    Optional<Product1> findByName(String fileName);
}
