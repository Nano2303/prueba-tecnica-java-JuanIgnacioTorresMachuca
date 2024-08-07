package com.example.demo.controller;

import com.example.demo.model.Prices;
import com.example.demo.service.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(PricesController.class)
public class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @BeforeEach
    void setup() {
        when(priceService.getPrices(35455, 1, "2020-06-14-10.00.00"))
                .thenReturn(new Prices(35455, 1, 1, "2020-06-14-00.00.00", "2020-12-31-23.59.59", 35.50f));

        when(priceService.getPrices(35455, 1, "2020-06-14-16.00.00"))
                .thenReturn(new Prices(35455, 1, 2, "2020-06-14-15.00.00", "2020-06-14-18.30.00", 25.45f));

        when(priceService.getPrices(35455, 1, "2020-06-14-21.00.00"))
                .thenReturn(new Prices(35455, 1, 2, "2020-06-14-15.00.00", "2020-06-14-18.30.00", 25.45f));

        when(priceService.getPrices(35455, 1, "2020-06-15-10.00.00"))
                .thenReturn(new Prices(35455, 1, 3, "2020-06-15-00.00.00", "2020-06-15-11.00.00", 30.50f));

        when(priceService.getPrices(35455, 1, "2020-06-16-21.00.00"))
                .thenReturn(new Prices(35455, 1, 4, "2020-06-15-16.00.00", "2020-12-31-23.59.59", 38.95f));
    }

    @Test
    public void test1() throws Exception { // petición a las 10:00 del día 14 del producto 35455 para la brand 1
        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("application_date", "2020-06-14-10.00.00")
                        .param("product_id", "35455")
                        .param("brand_id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-14-00.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-12-31-23.59.59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));
    }

    @Test
    public void test2() throws Exception { // petición a las 16:00 del día 14 del producto 35455 para la brand 1
        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("application_date", "2020-06-14-16.00.00")
                        .param("product_id", "35455")
                        .param("brand_id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-14-15.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-06-14-18.30.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45));
    }

    @Test
    public void test3() throws Exception { //petición a las 21:00 del día 14 del producto 35455 para la brand 1
        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("application_date", "2020-06-14-21.00.00")
                        .param("product_id", "35455")
                        .param("brand_id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-14-15.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-06-14-18.30.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45));
    }

    @Test
    public void test4() throws Exception { //petición a las 10:00 del día 15 del producto 35455 para la brand 1
        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("application_date", "2020-06-15-10.00.00")
                        .param("product_id", "35455")
                        .param("brand_id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-15-00.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-06-15-11.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50));
    }

    @Test
    public void test5() throws Exception { //petición a las 21:00 del día 16 del producto 35455 para la brand 1
        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("application_date", "2020-06-16-21.00.00")
                        .param("product_id", "35455")
                        .param("brand_id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-15-16.00.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-12-31-23.59.59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95));
    }
}
