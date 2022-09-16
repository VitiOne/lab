package com.lab.infrastructure.h2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class PriceRequestDBDto {
    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;
}
