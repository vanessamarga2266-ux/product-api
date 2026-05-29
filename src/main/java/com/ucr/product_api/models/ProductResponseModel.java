package com.ucr.product_api.models;
import java.math.BigDecimal;

public class ProductResponseModel {
    private String name;
    private String description;
    private BigDecimal price;

    public ProductResponseModel() {

}

        public ProductResponseModel(String name, String description, BigDecimal price){
            this.name = name;
            this.description = description;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String toString() {
            return "ProductResponseModel{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
