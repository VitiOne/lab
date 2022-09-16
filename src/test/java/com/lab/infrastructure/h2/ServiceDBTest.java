package com.lab.infrastructure.h2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.lab.application.PricesObjectTest;
import com.lab.infrastructure.h2.dto.PriceRequestDBDto;
import com.lab.infrastructure.h2.dto.PriceResponseDBDto;
import com.lab.infrastructure.h2.entity.Prices;
import com.lab.application.map.PriceDBEntityMapper;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceDBTest {

  @Mock
  private PriceRepository priceRepository;

  private ServiceDB serviceDB;

  @BeforeEach
  public void initEach(){
    serviceDB = new ServiceDB(priceRepository);
  }

  @Test
  void findPrice(){
    PriceRequestDBDto priceRequestDBDto = PricesObjectTest.getPriceRequestDBDto();
    Prices prices = PricesObjectTest.getPrices();
    List<Prices> list = Arrays.asList(prices);
    PriceResponseDBDto priceResponseDBDto = PricesObjectTest.getPriceResponseDBDto();

    when(priceRepository.price(priceRequestDBDto.getProductId(), priceRequestDBDto.getBrandId(), priceRequestDBDto.getApplicationDate()))
            .thenReturn(list);

    PriceResponseDBDto price = serviceDB.findPrice(priceRequestDBDto);
    assertEquals(price,priceResponseDBDto);
  }
}
