package com.example.hrle.android_portal.model;

import android.graphics.Bitmap;
import android.location.Location;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by HrLe on 3/31/2018.
 */

public class Post {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("photo")
    private String photo;
    @SerializedName("user")
    private String author;
    @SerializedName("date")
    private String date;
    @SerializedName("location")
    private String location;
    @SerializedName("tags")
    private String tags;
    @SerializedName("likes")
    private String likes;
    @SerializedName("dislikes")
    private String dislikes;

    //private List<Comment> comments;

    public Post() {

    }

    public Post(String id, String title, String description, String photo, String author, String date, String location, String tags, String likes, String dislikes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.author = author;
        this.date = date;
        this.location = location;
        this.tags = tags;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

   // public List<Comment> getComments() {
     //   return comments;
   // }

   // public void setComments(List<Comment> comments) {
       // this.comments = comments;
   // }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public void setDislikes(String dislikes) {
        this.dislikes = dislikes;
    }


}
