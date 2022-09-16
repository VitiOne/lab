package com.lab.application;

import com.lab.domain.PriceInDom;
import com.lab.domain.PriceOutDom;
import com.lab.infrastructure.h2.dto.PriceRequestDBDto;
import com.lab.infrastructure.h2.dto.PriceResponseDBDto;
import com.lab.infrastructure.h2.entity.Prices;
import com.lab.infrastructure.rest.dto.PriceRequestDto;
import com.lab.infrastructure.rest.dto.PriceResponseDto;
import java.time.LocalDateTime;
import java.util.List;

public class PricesObjectTest {

  public static PriceRequestDto getPriceRequestDto() {
    return PriceRequestDto.builder()
        .productId(35455L)
        .brandId(1L)
        .applicationDate(LocalDateTime.of(2022, 12, 28, 12, 0))
        .build();
  }

  public static PriceResponseDto getPriceResponseDto() {
    return PriceResponseDto.builder()
        .productId(35455L)
        .brandId(1L)
        .startDate(LocalDateTime.of(2022, 12, 28, 12, 0))
        .endDate(LocalDateTime.of(2022, 12, 28, 12, 0))
        .priceList(45L)
        .price(24.5)
        .build();
  }

  public static PriceInDom getPrice() {
    return PriceInDom.builder()
        .productId(35455L)
        .brandId(1L)
        .applicationDate(LocalDateTime.of(2022, 12, 28, 12, 0))
        .build();
  }
  public static PriceOutDom getPriceOut() {

    return PriceOutDom.builder()
          .productId(35455L)
          .brandId(1L)
          .startDate(LocalDateTime.of(2022, 12, 28, 12, 0))
          .endDate(LocalDateTime.of(2022, 12, 28, 12, 0))
          .priceList(45L)
          .price(24.5)
          .build();
  }

  public static PriceRequestDBDto getPriceRequestDBDto() {
    return PriceRequestDBDto.builder()
        .productId(35455L)
        .brandId(1L)
        .applicationDate(LocalDateTime.of(2022, 12, 28, 12, 0)).build();
  }

  public static PriceResponseDBDto getPriceResponseDBDto() {
    return PriceResponseDBDto.builder()
          .productId(35455L).brandId(1L)
          .startDate(LocalDateTime.of(2022, 12, 28, 12, 0))
          .endDate(LocalDateTime.of(2022, 12, 28, 12, 0))
          .priceList(45L).price(24.5).build();
  }


  public static Prices getPrices() {

    return Prices.builder()
          .brandId(1L)
          .productId(35455L)
          .priceId(0L)
          .price(24.5)
          .priceList(45L)
          .startDate(LocalDateTime.of(2022, 12, 28, 12, 0))
          .endDate(LocalDateTime.of(2022, 12, 28, 12, 0))
          .build();
  }

  public static List<Prices> getLisPrices() {
    return List.of(Prices.builder()
        .priceId(0L)
        .brandId(1L)
        .startDate(LocalDateTime.of(2020, 6, 14, 0, 0,0))
        .endDate(LocalDateTime.of(2020, 12, 31, 23, 59,59))
        .priceList(1L)
        .productId(35455L)
            .priority(0L)
        .price(35.50)
            .currency("EUR")
        .build(),
        Prices.builder()
            .priceId(2L)
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 14, 15, 0,0))
            .endDate(LocalDateTime.of(2020, 6, 14, 18, 30,0))
            .priceList(2L)
            .productId(35455L)
            .priority(1L)
            .price(25.45)
            .currency("EUR")
            .build(),
        Prices.builder()
            .priceId(3L)
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 15, 0, 0,0))
            .endDate(LocalDateTime.of(2020, 6, 15, 11, 0,0))
            .priceList(3L)
            .productId(35455L)
            .priority(1L)
            .price(30.50)
            .currency("EUR")
            .build(),
        Prices.builder()
            .priceId(4L)
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 15, 16, 0,0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59,59))
            .priceList(4L)
            .productId(35455L)
            .priority(1L)
            .price(38.95)
            .currency("EUR")
            .build()
        );
  }
}
