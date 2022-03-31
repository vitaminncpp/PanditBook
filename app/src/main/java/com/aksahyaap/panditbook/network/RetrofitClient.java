package com.aksahyaap.panditbook.network;


import android.content.res.Resources;
import android.util.Log;


import com.aksahyaap.panditbook.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static APIInterface api;
    private static Retrofit retrofit;
    private static final String baseurl;
    static {
        baseurl= "http://192.168.106.227:8080";//Resources.getSystem().getString(R.string.server_url);
        Log.i("server_url",baseurl);
        retrofit =new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
        api=retrofit.create(APIInterface.class);
    }

    public static Retrofit getRetrofit(){
        return retrofit;
    }
    public static APIInterface getInstance(){
        if(api==null){
            api =  retrofit.create(APIInterface.class);
        }
        return api;
    }
}
