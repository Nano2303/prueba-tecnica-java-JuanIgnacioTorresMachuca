package com.example.demo.service;

import com.example.demo.model.Prices;
import com.example.demo.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceService {

    @Autowired
    private PricesRepository pricesRepository;

    public Prices getPrices(Integer product_id, Integer brand_id, String application_date){
        List<Prices> prices = pricesRepository.findAll();


        List<Prices> filterPrices = prices.stream()
                .filter(p -> p.getProduct_id().equals(product_id))
                .filter(p -> p.getBrand_id().equals(brand_id))
                .filter(p -> p.getStart_date().compareTo(application_date) <= 0)
                .filter(p -> p.getEnd_date().compareTo(application_date) >= 0)
                .sorted((p1, p2) -> p2.getPriority().compareTo(p1.getPriority()))
                .findFirst()
                .stream()
                .collect(Collectors.toList());


         Prices finalPrice = new Prices(filterPrices.get(0).getProduct_id(),filterPrices.get(0).getBrand_id(),filterPrices.get(0).getPrice_list(),
                 filterPrices.get(0).getStart_date(),filterPrices.get(0).getEnd_date(),filterPrices.get(0).getPrice());


        return finalPrice;
    }
}