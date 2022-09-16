package com.lab.application.map;

import com.lab.infrastructure.h2.dto.PriceRequestDBDto;
import com.lab.infrastructure.h2.dto.PriceResponseDBDto;
import com.lab.infrastructure.h2.entity.Prices;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDBEntityMapper {

    Prices toInfrastructure(PriceRequestDBDto priceRequestDBDto);

    PriceResponseDBDto toDomain(Prices priceEntity);
}
