package com.example.pankaj.modelview.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pankaj.modelview.R;
import com.example.pankaj.modelview.databinding.ProductBinding;
import com.example.pankaj.modelview.viewmodel.ProductsViewModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomView> {


    private ArrayList<ProductsViewModel> arrayList;
    private Context context;
     private LayoutInflater layoutInflater;

    public CustomAdapter( Context context ,ArrayList<ProductsViewModel> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        if(layoutInflater==null){

            layoutInflater = LayoutInflater.from(parent.getContext());

        }

        ProductBinding productBinding =DataBindingUtil.inflate(layoutInflater, R.layout.innerlayout,parent,false);


        return new CustomView(productBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView customView, int i) {


        ProductsViewModel productsViewModel = arrayList.get(i);
        customView.bind(productsViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder{
        private ProductBinding productBinding;

        public CustomView(@NonNull ProductBinding productBinding) {
            super(productBinding.getRoot());
            this.productBinding = productBinding;
        }

        public void bind(ProductsViewModel productsViewModel){
            this.productBinding.setProductmodel(productsViewModel);
            productBinding.executePendingBindings();
        }

        public ProductBinding getProductBinding(){
            return productBinding;
        }
    }
}
