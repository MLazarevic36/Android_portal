package com.example.hrle.android_portal.DAO;

import com.example.hrle.android_portal.RegisterActivity;
import com.example.hrle.android_portal.model.Comment;

import com.example.hrle.android_portal.model.CommentRequest;
import com.example.hrle.android_portal.model.Content;
import com.example.hrle.android_portal.model.Example;
import com.example.hrle.android_portal.model.LoginRequest;
import com.example.hrle.android_portal.model.Post;

import com.example.hrle.android_portal.model.PostRequest;
import com.example.hrle.android_portal.model.PostResponse;
import com.example.hrle.android_portal.model.PostsList;
import com.example.hrle.android_portal.model.RegisterRequest;
import com.example.hrle.android_portal.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RestAPI {

   // String BASE_URL = "http://192.168.0.18:8080/";



    @GET("api/posts")
    Call<Example> getPosts(@Header("Authorization") String tokenCeo);

    @GET("api/posts/{id}")
    Call<PostResponse> getPost(@Path("id") long id, @Header("Authorization") String tokenCeo);

    @POST("api/posts")
    Call<Post> createPost(@Body Post post);

    @GET("api/posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int id);

    @POST("api/posts/{userId}")
    Call<PostRequest> createPost(@Path("userId") int userId, @Body CommentRequest commentRequest);

    @POST("api/posts/{postId}/comments/{userId}")
    Call<CommentRequest> createComment(@Path("postId") int postId, @Path("userId") int userId, @Body CommentRequest commentRequest);

    @DELETE("api/posts/{id}")
    Call<ResponseBody> deletePost(@Path("id") int id_za_brisanje);

    @POST("api/auth/signin")
    Call<LoginRequest> signIn(@Body LoginRequest loginRequest);

    @POST("api/auth/signup")
    Call<RegisterRequest> signUp(@Body RegisterRequest registerRequest);
}
