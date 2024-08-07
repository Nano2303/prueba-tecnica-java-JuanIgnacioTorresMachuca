package com.example.demo.controller;

import com.example.demo.model.Prices;
import com.example.demo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PricesController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/prices")
    public Prices getPrices(
            @RequestParam String application_date,
            @RequestParam Integer product_id,
            @RequestParam Integer brand_id
    ){
    return priceService.getPrices(product_id,brand_id,application_date);
    }

}
