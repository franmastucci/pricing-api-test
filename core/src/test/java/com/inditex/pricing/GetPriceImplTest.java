package com.inditex.pricing;

import com.inditex.pricing.application.GetPrice;
import com.inditex.pricing.application.impl.GetPriceImpl;
import com.inditex.pricing.domain.PriceDomain;
import com.inditex.pricing.domain.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import com.inditex.utils.TestUtils;

public class GetPriceImplTest {

    @Mock
    private PriceRepository priceRepository;

    private GetPrice getPrice;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        getPrice = new GetPriceImpl(priceRepository);
    }

    @Test
    void should_return_a_price_domain_object() throws IOException {

        String brandName = "ZARA";
        Long productId = 35455L;
        Timestamp date = new Timestamp(2020,06,16,21,00,00,00);

        var json = TestUtils.fileToJson("mocks/PriceDomain-Mock.json");
        var priceDomain = TestUtils.getObj(json, PriceDomain.class);

        doReturn(priceDomain)
                .when(priceRepository).findMaxPriorityPrice(brandName, productId, date);

        assertEquals(getPrice.getPrice(date, productId, brandName), priceDomain);

    }

}
