package com.aksahyaap.panditbook.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class User implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("uType")
    private int uType;
    @SerializedName("bDate")
    private String bDate;
    @SerializedName("phone")
    private String phone;
    @SerializedName("address")
    private String address;
    @SerializedName("pHash")
    private String pHash;
    @SerializedName("description")
    private String description;

    public User(String name, String email, int uType, String bDate, String phone, String address, String pHash,String description) {
        this.name = name;
        this.email = email;
        this.uType = uType;
        this.bDate = bDate;
        this.phone = phone;
        this.address = address;
        this.pHash = pHash;
        this.description=description;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getuType() {
        return uType;
    }

    public void setuType(int uType) {
        this.uType = uType;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getpHash() {
        return pHash;
    }

    public void setpHash(String pHash) {
        this.pHash = pHash;
    }

    public  String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ",\" email\":'" + email + '\"' +
                ",\"uType\":" + uType +
                ",\"bDate\":\"" + bDate + '\"' +
                ",\"phone\":\"" + phone + '\"' +
                ",\"address\":\"" + address + '\"' +
                ",\"pHash\":\"" + pHash + '\"' +
                '}';
    }
}
