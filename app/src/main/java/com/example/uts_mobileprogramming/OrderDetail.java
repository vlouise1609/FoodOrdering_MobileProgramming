package com.example.uts_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class OrderDetail extends AppCompatActivity {

    String intent_name, intent_price;
    ArrayList<ItemSold> itemSoldList;
    PrefManager sharedPreferences;
    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        //bikin shared preferences
        sharedPreferences = new PrefManager();

        //cari id di layout
        ImageView imageView = findViewById(R.id.order_detail_img);
        TextView itemName = findViewById(R.id.order_detail_name);
        TextView itemPrice = findViewById(R.id.order_detail_price);
        EditText quanEditText;
        quanEditText = findViewById(R.id.quan);

        //ambil img
        Bundle intent_img = getIntent().getExtras();
        if (intent_img!=null){
            int item_img = intent_img.getInt("itemImage");
            imageView.setImageResource(item_img);
        }

        Intent intent = getIntent();
        intent_name = intent.getStringExtra(FoodAdapter.EXTRA_NAME);
        intent_price = intent.getStringExtra(FoodAdapter.EXTRA_PRICE);

        itemName.setText(intent_name);
        itemPrice.setText(intent_price);


        //button myorder
        final Button btn_myOrder = findViewById(R.id.myOrder);
        btn_myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderDetail.this, MyOrder.class);
                sharedPreferences.saveItemSold(OrderDetail.this, itemSoldList);
                //saveData();
                startActivity(intent);
            }
        });

        //button ordermore
        final Button btn_orderMore = findViewById(R.id.orderMore);
        btn_orderMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.saveItemSold(OrderDetail.this, itemSoldList);
                finish();
            }
        });

        if(itemSoldList==null){
            itemSoldList = new ArrayList<ItemSold>();
        } else{
            itemSoldList = sharedPreferences.getItemSold(OrderDetail.this);
        }

        //button order more
        final Button btn_order_now = findViewById(R.id.orderNow);
        btn_order_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ambil value quantity dari edittext
                String temp = quanEditText.getText().toString();
                if(!"".equals(temp)){
                    quantity=Integer.parseInt(temp);
                }

                //itemSoldList.add(new ItemSold(intent_name, Integer.parseInt(intent_price), quantity));
                //PrefManager.savePref(OrderDetail.this, PrefManager.KEY_PROPERTIES, itemSoldList);

                ItemSold item = new ItemSold();
                item.name = intent_name;
                item.price = Integer.parseInt(intent_price);
                item.quantity = quantity;
                itemSoldList.add(item);

                sharedPreferences.saveItemSold(OrderDetail.this, itemSoldList);

//                String info = "data save" + String.valueOf(itemSoldList.size());
//                Toast.makeText(OrderDetail.this, info, Toast.LENGTH_LONG).show();

            }

        });


    }





}

