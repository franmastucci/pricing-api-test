package com.inditex.pricing.repository;


import com.inditex.pricing.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyJPARepository extends JpaRepository<CurrencyEntity, Integer> {
}

