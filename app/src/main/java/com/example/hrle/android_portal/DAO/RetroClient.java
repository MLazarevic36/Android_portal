package com.example.hrle.android_portal.DAO;

import com.example.hrle.android_portal.model.Content;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;


public class RetroClient {

    private static final String BASE_URL = "http://192.168.0.18:8080/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static RestAPI getRestAPI() {
        return getRetrofitInstance().create(RestAPI.class);
    }


    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(Content.class, new RestDeserializer<>(Content.class, "content"))
            .create();




}
