package com.example.uts_mobileprogramming;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    private Context ctx;
    ArrayList<ItemSold> listItemSold;
    private OnMyOrderList onMyOrderList;
    int status=0, temp_total;
    PrefManager sharedPreferences;

    public MyOrderAdapter(Context ctx, ArrayList<ItemSold> listItemSold) {
        this.ctx = ctx;
        this.listItemSold = listItemSold;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_sold_order, parent, false);
        sharedPreferences = new PrefManager();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemSold currentItem = listItemSold.get(position);
        holder.itemSoldName.setText(currentItem.name);
        holder.itemSoldPrice.setText(String.valueOf(currentItem.price));
        holder.quantitySold.setText(String.valueOf(currentItem.quantity));

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItemSold.remove(position);
                PrefManager.clear(ctx);
                sharedPreferences.removeItemSold(ctx, currentItem);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(listItemSold == null){
            return 0;
        }
//        String info = "data ada " + String.valueOf(listItemSold.size());
//        Toast.makeText(ctx, info, Toast.LENGTH_LONG).show();
        return listItemSold.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemSoldName, itemSoldPrice, quantitySold;
        Button deleteBtn, payNowBtn;
        ConstraintLayout llItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemSoldName = itemView.findViewById(R.id.itemSoldName);
            itemSoldPrice = itemView.findViewById(R.id.itemSoldPrice);
            quantitySold = itemView.findViewById(R.id.quantitySold);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            llItem = itemView.findViewById(R.id.ll_item);
            payNowBtn = (Button) itemView.findViewById(R.id.payNow);
        }
    }

    public int setVisibilitySeDeleteButton(int i){
        return this.status = i;
    }
//
//    @Override
//    public void onMyOrderList(int price, int quantity) {
//        temp_total = price*quantity;
//        total.setText(String.valueOf(temp_total));
//    }

}
