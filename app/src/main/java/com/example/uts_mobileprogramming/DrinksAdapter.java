package com.example.uts_mobileprogramming;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ViewHolder> {
    public static final String EXTRA_NAME = "com.example.application.example.EXTRA_NAME";
    public static final String EXTRA_PRICE = "com.example.application.example.EXTRA_PRICE";

    Context ctx;
    ArrayList<Item> listItem;

    public DrinksAdapter(Context ctx, ArrayList<Item> listItem) {
        this.ctx = ctx;
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public DrinksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_row_menu, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksAdapter.ViewHolder holder, int position) {
        Item item = listItem.get(position);
        holder.itemImg.setImageResource(item.imgUrl);
        holder.itemName.setText(item.name);
        holder.itemPrice.setText(String.valueOf(item.price));

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView itemImg;
        TextView itemName, itemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.itemImg);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Item item = listItem.get(position);

            String info = "Price: " + item.price;
            Toast.makeText(ctx, info, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(ctx, OrderDetail.class);
            intent.putExtra("itemImage", item.imgUrl);
            intent.putExtra(EXTRA_NAME, item.name);
            intent.putExtra(EXTRA_PRICE, Integer.toString(item.price));
            ctx.startActivity(intent);
        }
    }

}
