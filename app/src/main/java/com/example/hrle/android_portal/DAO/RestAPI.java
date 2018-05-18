package com.example.hrle.android_portal.DAO;

import com.example.hrle.android_portal.model.Post;
import com.example.hrle.android_portal.model.PostsList;
import com.example.hrle.android_portal.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface RestAPI {

   // String BASE_URL = "http://192.168.0.18:8080/";

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("users")
    Call<List<User>> getUsers();
}
