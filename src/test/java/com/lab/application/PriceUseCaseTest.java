package com.lab.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.lab.application.map.PriceDomainMapper;
import com.lab.domain.PriceInDom;
import com.lab.domain.PriceOutDom;
import com.lab.infrastructure.h2.ServiceDB;
import com.lab.infrastructure.h2.dto.PriceRequestDBDto;
import com.lab.application.map.PriceDBMapper;
import com.lab.infrastructure.h2.dto.PriceResponseDBDto;
import com.lab.infrastructure.rest.dto.PriceRequestDto;
import com.lab.infrastructure.rest.dto.PriceResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceUseCaseTest {

  @Mock
  private PriceDomainMapper priceDomainMapper;

  @Mock
  private PriceDBMapper priceDBMapper;

  @Mock
  private ServiceDB serviceDB;

  private PriceUseCase priceUseCase;

  private PriceRequestDto priceRequestDto = PricesObjectTest.getPriceRequestDto();

  private PriceResponseDto priceResponseDto = PricesObjectTest.getPriceResponseDto();

  private PriceInDom priceInDom = PricesObjectTest.getPrice();
  private PriceOutDom priceOutDom = PricesObjectTest.getPriceOut();

  private PriceRequestDBDto priceRequestDBDto = PricesObjectTest.getPriceRequestDBDto();
  private PriceResponseDBDto priceResponseDBDto = PricesObjectTest.getPriceResponseDBDto();

  @BeforeEach
  public void initEach(){
    priceUseCase = new PriceUseCase(priceDomainMapper, priceDBMapper, serviceDB);
  }

  @Test
  void priceTest() {

    when(priceDomainMapper.toDomain(priceRequestDto)).thenReturn(priceInDom);
    when(priceDBMapper.toInfrastructure(priceInDom)).thenReturn(priceRequestDBDto);
    when(serviceDB.findPrice(priceRequestDBDto)).thenReturn(priceResponseDBDto);
    when(priceDBMapper.toDomain(priceResponseDBDto)).thenReturn(priceOutDom);
    when(priceDomainMapper.toInfrastructure(priceOutDom)).thenReturn(priceResponseDto);

    PriceResponseDto expected = PricesObjectTest.getPriceResponseDto();

    PriceResponseDto actual = priceUseCase.price(priceRequestDto);

    assertEquals(expected,actual);
  }

//  @Test
//  void priceTestNull() {
//
//    when(priceDomainMapper.toDomain(priceRequestDto)).thenReturn(priceInDom);
//    when(priceDBMapper.toInfrastructure(priceInDom)).thenReturn(priceRequestDBDto);
//    when(serviceDB.findPrice(priceRequestDBDto)).thenReturn(priceResponseDBDto);
//    when(priceDBMapper.toDomain(priceResponseDBDto)).thenReturn(null);
//    when(priceDomainMapper.toInfrastructure(priceOutDom)).thenReturn(priceResponseDto);
//
//    PriceResponseDto expected = null;
//
//    PriceResponseDto actual = priceUseCase.price(priceRequestDto);
//
//    assertEquals(expected,actual);
//
//  }
}
