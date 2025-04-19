package com.inditex.pricing.adapter;

import com.inditex.pricing.domain.PriceDomain;
import com.inditex.pricing.domain.PriceRepository;
import com.inditex.pricing.mapper.PriceInfraMapper;
import com.inditex.pricing.repository.PriceJPARepository;
import com.inditex.shared.exception.InfraException;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

import static com.inditex.utils.InfraConstants.*;

/** The Constant log. */
@Log4j2

/**
 * The class PriceRepositoryImpl.
 */
@Repository
public class PriceRepositoryImpl implements PriceRepository {

    @Autowired
    private PriceJPARepository priceJPARepository;


    @Override
    public PriceDomain findMaxPriorityPrice(String brandName, Long productId, Timestamp appDate) {

        try {
            log.debug(PRICE_LOG_ADAPTER_CALLING_REPOSITORY);
            var price = priceJPARepository.findMaxPriorityPrice(brandName, productId, appDate);

            if (price.isPresent())
                return PriceInfraMapper.INSTANCE.map(price.get());

        } catch (Exception e) {
            log.error(PRICE_ERROR_EXCEPTION);
            throw new InfraException(PRICE_ERROR_EXCEPTION+ e.getMessage(), "500");
        }

        return null;

    }

}
