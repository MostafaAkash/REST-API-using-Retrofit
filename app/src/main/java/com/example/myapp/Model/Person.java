package com.example.myapp.Model;

import com.google.gson.annotations.SerializedName;

public class Person {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("User")
    private String mobileNumber;
    @SerializedName("image")
    private String imageUrl;
    @SerializedName("who")
    private String profession;

    public Person() {
    }

    public Person(String id, String name, String mobileNumber, String imageUrl, String profession) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.imageUrl = imageUrl;
        this.profession = profession;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
