package com.aksahyaap.panditbook.network;


import android.content.res.Resources;
import android.util.Log;


import com.aksahyaap.panditbook.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String baseurl;
    static {
        baseurl= "http://192.168.91.172:8080/register/";       //Resources.getSystem().getString(R.string.server_url);
        Log.i("server_url",baseurl);
        retrofit =new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static Retrofit getRetrofit(){
        return retrofit;
    }
}
