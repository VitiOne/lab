
package com.lab.infrastructure.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.lab.application.PriceUseCase;
import com.lab.application.PricesObjectTest;
import com.lab.infrastructure.rest.dto.PriceRequestDto;
import com.lab.infrastructure.rest.dto.PriceResponseDto;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class ControllerPriceTest {

    private PriceController priceController;
    @Mock
    private PriceUseCase priceUseCase;

    private PriceRequestDto priceRequestDto = PricesObjectTest.getPriceRequestDto();
    private PriceResponseDto priceResponseDto = PricesObjectTest.getPriceResponseDto();

    @BeforeEach
    public void initEach() {
        priceController = new PriceController(priceUseCase);
    }

    @Test
    public void controller(){

        LocalDateTime applicationDate = LocalDateTime.of(2022, 12, 28, 12, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        when(priceUseCase.price(priceRequestDto)).thenReturn(priceResponseDto);

        ResponseEntity<PriceResponseDto> expected = ResponseEntity.ok(priceResponseDto);
        ResponseEntity actual = priceController.prices(applicationDate,productId,brandId);

        assertEquals(priceResponseDto,actual.getBody());
    }
}
