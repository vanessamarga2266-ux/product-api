package com.ucr.product_api.models;

import java.math.BigDecimal;

public class MembershipResponseModel {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer durationDays;

    public MembershipResponseModel() {

    }

    public MembershipResponseModel(Long id, String name, String description, BigDecimal price, Integer durationDays) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationDays = durationDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public String toString() {
        return "MembershipResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", durationDays=" + durationDays +
                '}';

    }
}