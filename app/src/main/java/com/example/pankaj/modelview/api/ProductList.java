package com.example.pankaj.modelview.api;

import com.example.pankaj.modelview.model.Products;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class ProductList {


    @SerializedName("data")
    @Expose

private ArrayList<Products> products = new ArrayList<>();


   public ArrayList<Products> getProdects(){
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }
}
