package com.ucr.product_api.models;

import java.util.UUID;

public class TipoUserResponseModel {
    private UUID resourceId;
    private String name;
    private String description;

    public TipoUserResponseModel() {
        
    }

    public TipoUserResponseModel(UUID resourceId, String name, String description) {
        this.resourceId = resourceId;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "TipoUserResponseModel [resourceId=" + resourceId + ", name=" + name + ", description=" + description
                + "]";
    }
}