package com.example.hrle.android_portal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreationDateTime {

    @SerializedName("epochSecond")
    @Expose
    private Integer epochSecond;
    @SerializedName("nano")
    @Expose
    private Integer nano;

    public CreationDateTime() {
    }

    public CreationDateTime(Integer epochSecond, Integer nano) {
        super();
        this.epochSecond = epochSecond;
        this.nano = nano;
    }

    public Integer getEpochSecond() {
        return epochSecond;
    }

    public void setEpochSecond(Integer epochSecond) {
        this.epochSecond = epochSecond;
    }

    public Integer getNano() {
        return nano;
    }

    public void setNano(Integer nano) {
        this.nano = nano;
    }

}
