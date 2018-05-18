package com.example.hrle.android_portal.model;

import java.util.ArrayList;
import java.util.List;

public class PostsList {

    private List<Post> posts = new ArrayList<>();

    public PostsList(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
