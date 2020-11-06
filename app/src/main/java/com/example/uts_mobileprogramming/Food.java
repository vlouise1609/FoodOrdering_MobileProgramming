package com.example.uts_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Food extends AppCompatActivity {

    ArrayList<Item> listFood;
    RecyclerView rvItem;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        final Button btn_myOrder = findViewById(R.id.myOrder);
        btn_myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Food.this, MyOrder.class);
                startActivity(intent);
            }
        });

        rvItem = findViewById(R.id.rvFoodDrinks);
        rvItem.setNestedScrollingEnabled(false);

        listFood = new ArrayList<>();
        Item food1 = new Item();
        food1.name = "Roti Isi";
        food1.price = 20000;
        food1.imgUrl = R.drawable.sandwich;

        Item food2 = new Item();
        food2.name = "Bakso Urat";
        food2.price = 18000;
        food2.imgUrl = R.drawable.baksourat;

        Item food3 = new Item();
        food3.name = "Bakmi Effata";
        food3.price = 20000;
        food3.imgUrl = R.drawable.bakmieffata;

        Item food4 = new Item();
        food4.name = "Ayam Rocky";
        food4.price = 20000;
        food4.imgUrl = R.drawable.ayamrocky;

        Item food5 = new Item();
        food5.name = "Nasi goreng";
        food5.price = 20000;
        food5.imgUrl = R.drawable.nasigoreng;

        Item food6 = new Item();
        food6.name = "Bento";
        food6.price = 20000;
        food6.imgUrl = R.drawable.bento;

        listFood.add(food1);listFood.add(food2);
        listFood.add(food3);listFood.add(food4);
        listFood.add(food5);listFood.add(food6);

        rvItem.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new FoodAdapter(this, listFood);
        rvItem.setAdapter(adapter);
    }

}

