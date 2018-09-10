package com.example.hrle.android_portal.model;

import android.graphics.Bitmap;
import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HrLe on 3/31/2018.
 */

public class Post implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("likes")
    @Expose
    private int likes;
    @SerializedName("dislikes")
    @Expose
    private int dislikes;
    @SerializedName("comments")
    @Expose
    public Set<Comment> comments = new HashSet<Comment>();

    //private List<Comment> comments;

    public Post() {

    }

    public Post(String title, String description, String photo, User user, String date, String location, String tags, int likes, int dislikes) {

        this.title = title;
        this.description = description;
        this.photo = photo;
        this.user = user;
        this.date = date;
        this.location = location;
        this.tags = tags;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
