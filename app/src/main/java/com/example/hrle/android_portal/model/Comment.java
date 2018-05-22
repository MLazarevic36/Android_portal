package com.example.hrle.android_portal.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by HrLe on 3/31/2018.
 */

public class Comment {

    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("user")
    private User user;
    @SerializedName("date")
    private Date date;
    private Post post;
    @SerializedName("likes")
    private Integer likes;
    @SerializedName("dislikes")
    private Integer dislikes;

    public Comment() {

    }

    public Comment(Integer id, String title, String description, User user, Date date, Post post, Integer likes, Integer dislikes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.date = date;
        this.post = post;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }
}
