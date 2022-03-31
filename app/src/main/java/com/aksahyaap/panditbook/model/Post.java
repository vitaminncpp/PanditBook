package com.aksahyaap.panditbook.model;


import com.google.gson.annotations.SerializedName;

public class Post {
@SerializedName("_id")
    private String id;
    @SerializedName("uid")
    private String uid;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("date")
    private String date;
    @SerializedName("type")
    private Integer type;
    @SerializedName("location")
    private String location;
    @SerializedName("price")
    private Double price;

    public Post(String uid, String title, String content, String date, String location, Double price, Integer type) {

        this.uid = uid;
        this.title = title;
        this.content=content;
        this.date = date;

        this.location = location;
        this.price = price;
        this.type = type;
    }

    public Post() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void steContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String getId() {
        return id;
    }


    public void setId (String id) {
        this.id = id;
    }
}
