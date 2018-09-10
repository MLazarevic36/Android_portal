package com.example.hrle.android_portal.model;

import java.time.Instant;
import java.util.List;

public class PostResponse {

    private Long id;
    private String title;
    private String desc;
    private CreatedBy createdBy;
    private Instant creationDateTime;
    private String photo;
    private String tags;
    private Integer likes;
    private Integer dislikes;
    private List<CommentResponse> comments;

    public PostResponse(Long id, String title, String desc, CreatedBy createdBy, Instant creationDateTime, String photo, String tags, Integer likes, Integer dislikes, List<CommentResponse> comments) {
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
