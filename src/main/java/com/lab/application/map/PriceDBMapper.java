package com.lab.application.map;

import com.lab.domain.PriceInDom;
import com.lab.domain.PriceOutDom;
import com.lab.infrastructure.h2.dto.PriceRequestDBDto;
import com.lab.infrastructure.h2.dto.PriceResponseDBDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDBMapper {

    PriceRequestDBDto toInfrastructure(PriceInDom priceInDom);

    PriceOutDom toDomain(PriceResponseDBDto priceResponseDBDto);

}
