package com.example.hrle.android_portal.model;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by HrLe on 3/31/2018.
 */

public class User {

    private int id;
    private String name;
    private Bitmap photo;
    private String username;
    private String password;
    private List<Post> posts;
    private List<Comment> comments;
}
