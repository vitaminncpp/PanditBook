package com.aksahyaap.panditbook.users;

public class Pandit {
    private final String panditName;
    private final int panditRating;
    private final String panditBio;
    private final String panditLoc;

    public Pandit(String name, int rating, String bio, String loc){
        this.panditName = name;
        this.panditRating = rating;
        this.panditBio = bio;
        this.panditLoc = loc;
    }

    public String getPanditName(){
        return this.panditName;
    }
    public float getPanditRating(){
        return this.panditRating;
    }
    public String getPanditBio(){
        return this.panditBio;
    }
    public String getPanditLoc(){
        return this.panditLoc;
    }
}
