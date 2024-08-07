package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRICES")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"product_id", "brand_id", "price_list", "start_date", "end_date", "price"})
public class Prices {
    @Id
    private Long id;
    private Integer brand_id;
    private String start_date;
    private String end_date;
    private Integer price_list;
    private Integer product_id;
    private Integer priority;
    private Float price;
    private String curr;

    public Prices() {
    }

    public Prices(Integer product_id, Integer brand_id, Integer price_list,String start_date, String end_date, Float price) {
        this.product_id = product_id;
        this.brand_id = brand_id;
        this.price_list = price_list;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Integer getPrice_list() {
        return price_list;
    }

    public void setPrice_list(Integer price_list) {
        this.price_list = price_list;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}
