package com.ucr.product_api.models;

public class TipoUserResponseModel {
    private String name;
    private String description;

    public TipoUserResponseModel() {
        
    }

    public TipoUserResponseModel(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "TipoUserResponseModel [name=" + name + ", description=" + description + "]";
    }
}