package com.lab.application.map;

import com.lab.domain.PriceInDom;
import com.lab.domain.PriceOutDom;
import com.lab.infrastructure.rest.dto.PriceRequestDto;
import com.lab.infrastructure.rest.dto.PriceResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceInDom toDomain(PriceRequestDto priceRequestDto);
    PriceResponseDto toInfrastructure(PriceOutDom priceOutDom);
}
