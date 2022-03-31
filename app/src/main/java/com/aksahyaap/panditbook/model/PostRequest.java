package com.aksahyaap.panditbook.model;

import com.google.gson.annotations.SerializedName;

public class PostRequest {

    @SerializedName("user")
    private User user;
    @SerializedName("post")
    private Post post;

    public PostRequest() {
    }

    public PostRequest(User user, Post post) {
        this.user = user;
        this.post = post;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
