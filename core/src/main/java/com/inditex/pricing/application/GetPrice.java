package com.inditex.pricing.application;
import com.inditex.pricing.domain.PriceDomain;
import java.sql.Timestamp;

/**
 * The Interface GetPrice.
 */
public interface GetPrice {


    /**
     * Gets pricing
     *
     * @param date the execution date
     * @param product the product
     * @param brand the brand
     * @return a PriceDomain
     */

    public PriceDomain getPrice(Timestamp date, Long product, String brand);

}
