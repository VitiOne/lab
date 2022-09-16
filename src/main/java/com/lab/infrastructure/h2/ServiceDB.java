package com.lab.infrastructure.h2;

import com.lab.infrastructure.h2.dto.PriceRequestDBDto;
import com.lab.infrastructure.h2.dto.PriceResponseDBDto;
import com.lab.infrastructure.h2.entity.Prices;
import com.lab.application.map.PriceDBEntityMapper;
import java.time.LocalDateTime;
import javax.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ServiceDB {
    private final PriceRepository priceRepository;

    public PriceResponseDBDto findPrice(PriceRequestDBDto priceRequestDBDto){
        return Optional.ofNullable(priceRequestDBDto)
                .map(a-> priceRepository.price(priceRequestDBDto.getProductId(),priceRequestDBDto.getBrandId(),priceRequestDBDto.getApplicationDate()))
                .map(this::mapQuery)
                .orElse(null);
    }

    private PriceResponseDBDto mapQuery(List<Prices> prices){
        if(prices.size() == 0) return null;

        return PriceResponseDBDto.builder()
            .priceList(prices.get(0).getPriceList())
            .brandId(prices.get(0).getBrandId())
            .startDate(prices.get(0).getStartDate())
            .endDate(prices.get(0).getEndDate())
            .productId(prices.get(0).getProductId())
            .price(prices.get(0).getPrice())
            .build();
    }
}
