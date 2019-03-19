package com.example.pankaj.modelview.api;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.pankaj.modelview.NetworkUtils;
import com.example.pankaj.modelview.model.Products;
import com.example.pankaj.modelview.viewmodel.ProductsViewModel;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserReposotry {

    private  Context context;

    public MutableLiveData<ArrayList<ProductsViewModel>>  arrayListMutableLiveData = new MutableLiveData<>();

    private ArrayList<ProductsViewModel> arrayList;

    private ArrayList<Products> item;


    public UserReposotry(){
        }



    public MutableLiveData<ArrayList<ProductsViewModel>> getArrayListMutableLiveData(){
            final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Map<String,String> input = new HashMap<String,String >();
            input.put("category_id","17");
            input.put("user_id","9998");
            input.put("language_id","3");
            input.put("page","1");
            input.put("country_id","132");

            Map<String,String> header = new HashMap<String,String >();
            header.put("username","richestLifeAdmin");
            header.put("password","123456");
            header.put("Authorization","Bearer wScnBEsMTfepoaUGFhiqkjcP9F8gsT7MMdlgdnByzKIO4LbGyRYotAbioumv");

            Log.d("tag--------------------",input.get("user_id"));
            Call<ProductList> call = apiService.getProductLists(input);
            call.enqueue(new Callback<ProductList>() {


                @Override
                public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                    try {

                      item = response.body().getProdects();

                      Products products;

                      ProductsViewModel productsViewModel;

                        arrayList = new ArrayList<>();
                      for(int i = 0;i<item.size();i++){

                          products = new Products(item.get(i).title,item.get(i).qty,item.get(i).product_img);
                          productsViewModel = new ProductsViewModel(products);
                          arrayList.add(productsViewModel);
                       }
                        arrayListMutableLiveData.setValue(arrayList);


                        Log.d("Responsecvv-->", "method ca;;");


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ProductList> call, Throwable t) {

                }
            });



        return arrayListMutableLiveData;

    }

}
