package com.example.hrle.android_portal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HrLe on 3/31/2018.
 */


public class Comment {

    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("createdBy")
    @Expose
    private CreatedBy createdBy;
    @SerializedName("creationDateTime")
    @Expose
    private CreationDateTime creationDateTime;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("dislikes")
    private Integer dislikes;

    public Comment() {

    }

    public Comment(Integer id, String title, String desc, CreatedBy createdBy, CreationDateTime creationDateTime, Integer likes, Integer dislikes) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.createdBy = createdBy;
        this.creationDateTime = creationDateTime;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public CreationDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(CreationDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
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
