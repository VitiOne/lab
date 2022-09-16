package com.lab.infrastructure.rest.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequestDto {
    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;
}
