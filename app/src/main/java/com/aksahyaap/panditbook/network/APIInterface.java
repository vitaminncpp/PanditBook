package com.aksahyaap.panditbook.network;


import com.aksahyaap.panditbook.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("/register")
    Call<String> postData(@Body User user);

}
