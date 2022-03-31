package com.aksahyaap.panditbook.network;


import androidx.annotation.NonNull;

import com.aksahyaap.panditbook.model.Post;
import com.aksahyaap.panditbook.model.PostRequest;
import com.aksahyaap.panditbook.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface APIInterface {


    //Post Operations
    @POST("/post")
    Call<Post> post(@Body PostRequest request);

    //User Operations
    @POST("/register")
    Call<User> register(@Body User user);

    @POST("/login")
    Call<User> login(@Body User login);

    @POST("/post/edit")
    Call<Post> updatePost(@Body PostRequest request);

    @POST("post/delete")
    Call<String> deletePost(@Body PostRequest request);

    @POST("/getpost")
    Call<Post> getPost(@Body @NonNull PostRequest request);



}
