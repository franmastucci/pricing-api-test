package com.inditex.pricing.domain;

import java.sql.Timestamp;

/**
 * The Interface PriceRepository.
 */

public interface PriceRepository {


    /**
     * Find a max priority pricing
     *
     * @param brandName the execution brandName
     * @param productId the productId
     * @param appDate the appDate
     * @return a PriceDomain
     */

    public PriceDomain findMaxPriorityPrice(String brandName, Long productId, Timestamp appDate) ;

}