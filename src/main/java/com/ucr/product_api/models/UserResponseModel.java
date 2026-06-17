package com.ucr.product_api.models;

import java.util.UUID;

public class UserResponseModel {
  
    private Integer tipoUserId;

    private String fullName;

    private String email;

    private String password;

    private String phone;

    private UUID resourceId;

    public UserResponseModel() {
        
    }

    public UserResponseModel(Integer tipoUserId, String fullName, String email, String password, String phone,
            UUID resourceId) {
        this.tipoUserId = tipoUserId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.resourceId = resourceId;
    }

    public Integer getTipoUserId() {
        return tipoUserId;
    }

    public void setTipoUserId(Integer tipoUserId) {
        this.tipoUserId = tipoUserId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "UserResponseModel [tipoUserId=" + tipoUserId + ", fullName=" + fullName + ", email=" + email
                + ", password=" + password + ", phone=" + phone + ", resourceId=" + resourceId + "]";
    }
}