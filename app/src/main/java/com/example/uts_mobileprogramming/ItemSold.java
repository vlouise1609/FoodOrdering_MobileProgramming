package com.example.uts_mobileprogramming;


public class ItemSold {
    public String name;
    public int price;
    public int quantity;

    public ItemSold(String name, int price, int quantity) {
        super();
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }


    public ItemSold() {
        super();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

