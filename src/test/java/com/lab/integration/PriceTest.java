package com.lab.integration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.lab.application.PricesObjectTest;
import com.lab.infrastructure.h2.PriceRepository;
import com.lab.testcontainer.postgre.PostgresSQLTestContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class PriceTest {

    private static final PostgresSQLTestContainer postgresTestContainer;

    @Autowired
    PriceRepository priceRepository;

    @BeforeEach
    public void initEach(){
        populateDB();
    }
    static {
        postgresTestContainer = PostgresSQLTestContainer.getInstance();
        postgresTestContainer.start();
    }

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresTestContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgresTestContainer::getPassword);
        registry.add("spring.datasource.username", postgresTestContainer::getUsername);
    }

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource(
        {
            "'2020-06-14T10:00:00', '35.5', '1','2020-06-14T00:00:00','2020-12-31T23:59:59'",
            "'2020-06-14T16:00:00', '25.45', '2','2020-06-14T15:00:00','2020-06-14T18:30:00'",
            "'2020-06-14T21:00:00', '35.5', '1','2020-06-14T00:00:00','2020-12-31T23:59:59'",
            "'2020-06-15T10:00:00', '30.5', '3','2020-06-15T00:00:00','2020-06-15T11:00:00'",
            "'2020-06-21T16:00:00', '38.95', '4','2020-06-15T16:00:00','2020-12-31T23:59:59'"
        })
    void checkPrices(String dateTime,String priceExpected, String priceListExpected, String startDateExpected,String endDateExpected) throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/price?applicationDate="+dateTime+"&productId=35455&brandId=1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk())
            .andExpect(jsonPath("$.brandId").value(1))
            .andExpect(jsonPath("$.productId").value(35455))
            .andExpect(jsonPath("$.price").value(priceExpected))
            .andExpect(jsonPath("$.priceList").value(priceListExpected))
            .andExpect(jsonPath("$.startDate").value(startDateExpected))
            .andExpect(jsonPath("$.endDate").value(endDateExpected));
    }

    @ParameterizedTest
    @CsvSource(
        {
            "'2021-06-14T10:00:00'",
            "'2022-06-14T16:00:00'",
            "'2023-06-14T21:00:00'",
            "'2024-06-15T10:00:00'",
            "'2025-06-21T16:00:00'"
        })
    void checkPricesWhenNotExists(String parameter) throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/price?applicationDate="+parameter+"&productId=35455&brandId=1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
    }

    void populateDB() {
        priceRepository.saveAll(PricesObjectTest.getLisPrices());
    }
}
