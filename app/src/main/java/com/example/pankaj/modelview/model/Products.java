package com.example.pankaj.modelview.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products {

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("qty")
    @Expose
    public String qty;

    @SerializedName("product_img")
    @Expose
    public String product_img;

    public Products(String title, String qty, String product_img) {
        this.title = title;
        this.qty = qty;
        this.product_img = product_img;
    }

    public Products() {
    }
}
