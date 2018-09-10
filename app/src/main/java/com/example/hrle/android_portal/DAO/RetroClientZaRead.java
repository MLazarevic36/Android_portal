package com.example.hrle.android_portal.DAO;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClientZaRead {

    private static final String BASE_URL = "http://192.168.0.18:8080/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RestAPI getRestAPI() {
        return getRetrofitInstance().create(RestAPI.class);
    }



}
