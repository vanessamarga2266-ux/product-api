package com.ucr.product_api.models;

public class UserResponseModel {
    private long id;
    private Integer tipoUserId;
    private String fullName;
    private String email;
    private String password;
    private String phone;

    public UserResponseModel() {

    }

    public UserResponseModel(long id, Integer tipoUserId, String fullName, String email, String password,
            String phone) {
        this.id = id;
        this.tipoUserId = tipoUserId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserResponseModel [id=" + id +
        ", tipoUserId=" + tipoUserId +
        ", fullName=" + fullName +
        ", email=" + email + 
        ", password=" + password +
        ", phone=" + phone + "]";
    }
}
