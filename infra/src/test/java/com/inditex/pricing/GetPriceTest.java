package com.inditex.pricing;

import com.inditex.pricing.application.GetPrice;
import com.inditex.pricing.application.impl.GetPriceImpl;
import com.inditex.pricing.domain.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class GetPriceTest {

    @Autowired
    private PriceRepository priceRepository;

    private GetPrice getPrice;


    @BeforeEach
    void setup() {
        getPrice = new GetPriceImpl(priceRepository);
    }


    @Test
    void should_return_a_price_domain_object()  {

        String brandName = "ZARA";
        Long productId = 35455L;
        Timestamp date = new Timestamp(120,05,16,21,00,00,00);

        var priceDomainResponse = getPrice.getPrice(date,productId,brandName);

        assertEquals(priceDomainResponse.getCurrencyDomain().getName().getValue(), "EUR");

    }

}