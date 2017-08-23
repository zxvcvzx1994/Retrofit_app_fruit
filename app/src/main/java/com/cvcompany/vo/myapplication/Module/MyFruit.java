package com.cvcompany.vo.myapplication.Module;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vinh on 8/23/2017.
 */

public class MyFruit {
    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Picture")
    private String picture;
    @SerializedName("Price")
    private String price;

    public MyFruit(String id, String name, String picture, String price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.price = price;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
