package com.example.proyecto1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.proyecto1.Adaptor.CategoryAdaptor;
import com.example.proyecto1.Adaptor.PoplurarAdaptor;
import com.example.proyecto1.Domain.CategoryDomain;
import com.example.proyecto1.Domain.FoodDomain;
import com.example.proyecto1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        BottomNavigation();

    }
    private void BottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.CartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList <CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Pizzas","cat_1"));
        category.add(new CategoryDomain("Hamburguesas", "cat_2"));
        category.add(new CategoryDomain("Hotdogs", "cat_3"));
        category.add(new CategoryDomain("Bebidas", "cat_4"));
        category.add(new CategoryDomain("Donuts", "cat_5"));

        adapter=new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList=new ArrayList<>();
        foodList.add(new FoodDomain("Pizza Pepperoni","pizza","Masa Extrafina, Pasta de Tomates, Queso Mozzarella y Pepperoni",20.000));
        foodList.add(new FoodDomain("Hamburguesa","pop_2","Carne de Res, Queso Cheddar, Salsa Especial, Lechuga, Tomate",23.000));
        foodList.add(new FoodDomain("Pizza Vegetariana","pop_3","Masa Extrafina, Pasta De tomate, Queso Mozzarella, Pimenton,Cebolla, Tomate y Maiz",21.300));

        adapter2=new PoplurarAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}