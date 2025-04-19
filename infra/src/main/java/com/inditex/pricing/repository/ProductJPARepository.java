package com.inditex.pricing.repository;


import com.inditex.pricing.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<ProductEntity, Integer> {
}

