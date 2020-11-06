package com.example.uts_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_myOrder = findViewById(R.id.myOrder);
        btn_myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MyOrder.class);
                startActivity(myIntent);
            }
        });

        final Button btn_drinks = findViewById(R.id.drinks);
        btn_drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Drinks.class);
                startActivity(myIntent);
            }
        });

        final Button btn_snacks = findViewById(R.id.snacks);
        btn_snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Snack.class);
                startActivity(myIntent);
            }
        });

        final Button btn_foods = findViewById(R.id.foods);
            btn_foods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Food.class);
                startActivity(myIntent);
            }
        });

    }
}