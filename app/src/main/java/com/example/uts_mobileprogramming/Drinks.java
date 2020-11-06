package com.example.uts_mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Drinks extends AppCompatActivity {

    ArrayList<Item> listDrink;
    RecyclerView rvItem;
    DrinksAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        final Button btn_myOrder = findViewById(R.id.myOrder);
        btn_myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, MyOrder.class);
                startActivity(intent);
            }
        });

        rvItem = findViewById(R.id.rvFoodDrinks);
        rvItem.setNestedScrollingEnabled(false);

        listDrink = new ArrayList<>();
        Item drink1 = new Item();

        drink1.name = "Air Mineral";
        drink1.price = 5000;
        drink1.imgUrl = R.drawable.airmineral;

        Item drink2 = new Item();
        drink2.name = "Jus Mangga";
        drink2.price = 12000;
        drink2.imgUrl = R.drawable.jusmangga;

        Item drink3 = new Item();
        drink3.name = "Jus Apel";
        drink3.price = 15000;
        drink3.imgUrl = R.drawable.jusapel;

        Item drink4 = new Item();
        drink4.name = "Jus Alpukat";
        drink4.price = 20000;
        drink4.imgUrl = R.drawable.jusalpukat;

        Item drink5 = new Item();
        drink5.name = "Kopi Susu";
        drink5.price = 8000;
        drink5.imgUrl = R.drawable.kopisusu;

        Item drink6 = new Item();
        drink6.name = "Teh Manis";
        drink6.price = 5000;
        drink6.imgUrl = R.drawable.tehmanis;

        listDrink.add(drink1);listDrink.add(drink2);
        listDrink.add(drink3);listDrink.add(drink4);
        listDrink.add(drink5);listDrink.add(drink6);

        rvItem.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new DrinksAdapter(this, listDrink);
        rvItem.setAdapter(adapter);

        }



}

