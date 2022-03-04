package com.aksahyaap.panditbook.users;

public class Pandit {
    private final String panditName;
    private final int panditRating;

    public Pandit(String name, int rating){
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
