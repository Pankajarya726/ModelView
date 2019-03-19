package com.example.pankaj.modelview.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.pankaj.modelview.R;
import com.example.pankaj.modelview.api.UserReposotry;
import com.example.pankaj.modelview.model.Products;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductsViewModel extends ViewModel {
    public String title;
    public String qty;
    public String product_img;


    public MutableLiveData<ArrayList<ProductsViewModel>> arrayListMutableLiveData = new MutableLiveData<>();

    private ArrayList<ProductsViewModel> arrayList;

    private UserReposotry userReposotry;

    public String getimageUrl(){
        return product_img;
    }


    @BindingAdapter({"bind:imageUrl"})


    public static void loadImage(ImageView imageView, String imageUrl){
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(R.drawable.ic_launcher_background).into(imageView);
    }


    public ProductsViewModel(){
        userReposotry = new UserReposotry();
        arrayListMutableLiveData =   userReposotry.getArrayListMutableLiveData();
    }

    public ProductsViewModel(Products products){
        this.title =products.title;
        this.qty =products.qty;
        this.product_img =products.product_img;

    }

    public MutableLiveData<ArrayList<ProductsViewModel>> getArrayListMutableLiveData(){
        /*arrayList = new ArrayList<>();
        Products  products = new Products("pankaj 1","__10","image1.png");
        ProductsViewModel productsViewModel=new ProductsViewModel(products);
        arrayList.add(productsViewModel);
        arrayListMutableLiveData.setValue(arrayList);
*/

        return arrayListMutableLiveData;
    }

}
