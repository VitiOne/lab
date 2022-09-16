package com.lab.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceOutDom {

    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Long priceList;
    private Double price;
}
