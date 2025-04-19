package com.inditex.pricing.repository;


import com.inditex.pricing.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJPARepository extends JpaRepository<BrandEntity, Integer> {
}

