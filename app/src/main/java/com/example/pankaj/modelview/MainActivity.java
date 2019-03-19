package com.example.pankaj.modelview;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pankaj.modelview.adapter.CustomAdapter;
import com.example.pankaj.modelview.viewmodel.ProductsViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ProductsViewModel productsViewModel;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recyclerView);
    productsViewModel = ViewModelProviders.of(this).get(ProductsViewModel.class);


    productsViewModel.getArrayListMutableLiveData().observe(this, new Observer<ArrayList<ProductsViewModel>>() {
        @Override
        public void onChanged(@Nullable ArrayList<ProductsViewModel> productsViewModels) {
            customAdapter = new CustomAdapter(MainActivity.this,productsViewModels);
            recyclerView.setLayoutManager( new LinearLayoutManager(MainActivity.this));
            recyclerView.setAdapter(customAdapter);

        }
    });
      

    }





}
