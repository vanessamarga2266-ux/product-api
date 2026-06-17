package com.ucr.product_api.models;

import java.util.UUID;

public class MembershipResponseModel{
   private UUID resourceId;
   private String name;
    private String description;
    private Double price;
    private Integer durationDays;

    public MembershipResponseModel() {
    }

    public MembershipResponseModel(UUID resourceId, String name, String description, Double price, Integer durationDays) {
        this.resourceId = resourceId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationDays = durationDays;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    @Override
    public String toString() {
        return "MembershipResponseModel [resourceId=" + resourceId + ", name=" + name + ", description=" + description
                + ", price=" + price + ", durationDays=" + durationDays + "]";
    }
  
}