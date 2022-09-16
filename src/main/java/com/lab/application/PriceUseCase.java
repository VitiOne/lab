package com.lab.application;

import com.lab.application.map.PriceDomainMapper;
import com.lab.infrastructure.h2.ServiceDB;
import com.lab.application.map.PriceDBMapper;
import com.lab.infrastructure.rest.dto.PriceRequestDto;
import com.lab.infrastructure.rest.dto.PriceResponseDto;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PriceUseCase {

    private final PriceDomainMapper priceDomainMapper;

    private final PriceDBMapper priceDBMapper;

    private final ServiceDB serviceDB;

    public PriceResponseDto price(PriceRequestDto priceRequestDto){
         return Optional.ofNullable(priceRequestDto)
             .map(priceDomainMapper::toDomain)
             .map(priceDBMapper::toInfrastructure)
             .map(serviceDB::findPrice)
             .map(priceDBMapper::toDomain)
             .map(priceDomainMapper::toInfrastructure)
             .orElse(null);
    }
}
