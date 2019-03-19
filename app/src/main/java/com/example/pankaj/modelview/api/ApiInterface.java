package com.example.pankaj.modelview.api;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;


public interface ApiInterface {

    
    @Headers({"username:richestLifeAdmin","password:123456","Authorization:Bearer wScnBEsMTfepoaUGFhiqkjcP9F8gsT7MMdlgdnByzKIO4LbGyRYotAbioumv"})
    @POST("richestlife/api/getProductList")
    Call<ProductList> getProductLists(@QueryMap Map<String, String> input);
}
