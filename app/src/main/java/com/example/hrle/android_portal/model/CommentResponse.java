package com.example.hrle.android_portal.model;

import java.time.Instant;

public class CommentResponse {


    private Long id;
    private String title;
    private String desc;
    private CreatedBy createdBy;
    private Instant creationDateTime;
    private Integer likes;
    private Integer dislikes;

    public CommentResponse(Long id, String title, String desc, CreatedBy createdBy, Instant creationDateTime, Integer likes, Integer dislikes) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.createdBy = createdBy;
        this.creationDateTime = creationDateTime;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Instant getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Instant creationDateTime) {
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
