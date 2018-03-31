package com.example.hrle.android_portal.model;

import java.util.Date;

/**
 * Created by HrLe on 3/31/2018.
 */

public class Comment {
    private int id;
    private String title;
    private String description;
    private User author;
    private Date date;
    private Post post;
    private int likes;
    private int dislikes;
}
