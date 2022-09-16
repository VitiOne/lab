package com.lab.infrastructure.rest;

import com.lab.application.PriceUseCase;
import com.lab.infrastructure.rest.dto.PriceRequestDto;
import com.lab.infrastructure.rest.dto.PriceResponseDto;
import com.lab.application.map.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceUseCase priceUseCase;

    @GetMapping
    public ResponseEntity<PriceResponseDto> prices(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam Long productId,
            @RequestParam Long brandId){
        PriceRequestDto priceRequestDto= PriceRequestDto.builder()
                .applicationDate(applicationDate)
                .productId(productId)
                .brandId(brandId)
                .build();

      return Optional.ofNullable(priceRequestDto)
              .map(priceUseCase::price)
              .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
              .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
