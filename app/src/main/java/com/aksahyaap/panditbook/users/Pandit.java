package com.aksahyaap.panditbook.users;

public class Pandit {
    private String panditName;
    private float panditRating;

    Pandit(String name, float rating){
        this.panditName = name;
        this.panditRating = rating;
    }

    public String getPanditName(){
        return this.panditName;
    }
    public float getPanditRating(){
        return this.panditRating;
    }
}
