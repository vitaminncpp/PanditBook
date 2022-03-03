package com.aksahyaap.panditbook.models;


import com.google.gson.annotations.SerializedName;


public class User {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("uType")
    private int uType;
    @SerializedName("bDate")
    private String bDate;
    @SerializedName("phone")
    private long phone;
    @SerializedName("address")
    private String address;
    @SerializedName("pHash")
    private String pHash;

    public User(String name, String email, int uType, String bDate, long phone, String address, String pHash) {
        this.name = name;
        this.email = email;
        this.uType = uType;
        this.bDate = bDate;
        this.phone = phone;
        this.address = address;
        this.pHash = pHash;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
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
}
