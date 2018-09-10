package com.example.hrle.android_portal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    private String username;
    private String password;

    @SerializedName("accessToken")
    @Expose
    private String accessToken;

    @SerializedName("tokenType")
    @Expose
    private String tokenType;


    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
