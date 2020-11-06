package com.example.uts_mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Snack extends AppCompatActivity {

    ArrayList<Item> listSnacks;
    RecyclerView rvItem;
    SnackAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        final Button btn_myOrder = findViewById(R.id.myOrder);
        btn_myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Snack.this, MyOrder.class);
                startActivity(intent);
            }
        });

        rvItem = findViewById(R.id.rvFoodDrinks);
        rvItem.setNestedScrollingEnabled(false);


        listSnacks = new ArrayList<>();
        Item snack1 = new Item();
        snack1.name = "Ice Cream";
        snack1.price = 5000;
        snack1.imgUrl = R.drawable.icecream;

        Item snack2 = new Item();
        snack2.name = "Crepes";
        snack2.price = 8000;
        snack2.imgUrl = R.drawable.crepes;

        Item snack3 = new Item();
        snack3.name = "Kebab Isi";
        snack3.price = 12000;
        snack3.imgUrl = R.drawable.kebab;

        Item snack4 = new Item();
        snack4.name = "Salad buah";
        snack4.price = 8000;
        snack4.imgUrl = R.drawable.saladbuah;

        Item snack5 = new Item();
        snack5.name = "Martabak mini";
        snack5.price = 5000;
        snack5.imgUrl = R.drawable.martabakmini;

        Item snack6 = new Item();
        snack6.name = "Kentang Goreng";
        snack6.price = 10000;
        snack6.imgUrl = R.drawable.kentanggoreng;

        listSnacks.add(snack1);listSnacks.add(snack2);
        listSnacks.add(snack3);listSnacks.add(snack4);
        listSnacks.add(snack5);listSnacks.add(snack6);

        rvItem.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new SnackAdapter(this, listSnacks);
        rvItem.setAdapter(adapter);

    }

}