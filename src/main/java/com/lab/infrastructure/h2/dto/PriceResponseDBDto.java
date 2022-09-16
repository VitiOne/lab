package com.lab.infrastructure.h2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceResponseDBDto {
        private Long brandId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Long productId;
        private Long priceList;
        private Double price;
}
