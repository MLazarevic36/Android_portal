package com.example.hrle.android_portal.model;

public class RegisterRequest {

    private String name;
    private String username;
    private String password;
    private String photo;

    public RegisterRequest(String name, String username, String password, String photo) {

        this.name = name;
        this.username = username;
        this.password = password;
        this.photo = photo;
    }
}
