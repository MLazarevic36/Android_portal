package com.example.hrle.android_portal.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Content  {

    @SerializedName("id")
    @Expose
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
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("dislikes")
    @Expose
    private Integer dislikes;
    @SerializedName("comments")
    @Expose
    private List<CommentResponse> comments;

    public Content() {
    }

    public Content(Integer id, String title, String desc, CreatedBy createdBy, CreationDateTime creationDateTime, String photo, String tags, Integer likes, Integer dislikes, List<CommentResponse> comments) {
        super();
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.createdBy = createdBy;
        this.creationDateTime = creationDateTime;
        this.photo = photo;
        this.tags = tags;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public List<CommentResponse> getComments() {
        return comments;
    }

    public void setComments(List<CommentResponse> comments) {
        this.comments = comments;
    }


}
