package com.example.uts_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyOrder extends AppCompatActivity implements OnMyOrderList {

    ArrayList<ItemSold> listItemSold;
    PrefManager sharedPreferences;
    RecyclerView rvItem;
    MyOrderAdapter adapter;
    TextView total, finishText;
    ImageView imgView;
    int temp_total;
    Button payNow, homeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        //listItemSold.addAll(PrefManager.getPrefList(this, PrefManager.KEY_PROPERTIES, ItemSold[].class));
        sharedPreferences = new PrefManager();
        listItemSold = new ArrayList<ItemSold>();
        listItemSold = sharedPreferences.getItemSold(MyOrder.this);


        //loadData();


        rvItem = findViewById(R.id.rvListItem);
        rvItem.setHasFixedSize(true);
        rvItem.setNestedScrollingEnabled(false);
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyOrderAdapter(this, listItemSold);
        rvItem.setAdapter(adapter);

        finishText = findViewById(R.id.finish_text);
        homeBtn = findViewById(R.id.homeBtn);
        imgView = findViewById(R.id.imageView);

        //test nanti diapus
//        imgView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String info = "data save" + String.valueOf(listItemSold.size());
//                Toast.makeText(MyOrder.this, info, Toast.LENGTH_LONG).show();
//
//            }
//        });

        //total price
        total = findViewById(R.id.total);
        if(listItemSold!=null){
            for (int i=0;i<listItemSold.size();i++){
                temp_total += listItemSold.get(i).price * listItemSold.get(i).quantity;
            }
        }else {
            temp_total = 0;
        }
        total.setText(String.valueOf(temp_total));


        payNow = findViewById(R.id.payNow);
        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //invisible
                payNow.setVisibility(View.INVISIBLE);
                imgView.setVisibility(View.INVISIBLE);
                adapter.setVisibilitySeDeleteButton(1);

                //visible
                finishText.setVisibility(View.VISIBLE);
                homeBtn.setVisibility(View.VISIBLE);
                homeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sharedPreferences = new PrefManager();
                        sharedPreferences.clearData(MyOrder.this);
                        Intent intent2 = new Intent(MyOrder.this, MainActivity.class);
                        startActivity(intent2);
                    }
                });

            }
        });


    }


    @Override
    public void onMyOrderList(int price, int quantity) {
        temp_total = price*quantity;
        total.setText(String.valueOf(temp_total));
    }



}