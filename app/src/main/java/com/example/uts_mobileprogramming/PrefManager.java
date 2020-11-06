package com.example.uts_mobileprogramming;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefManager {
    public static final String KEY_PREF = "mypreferences";
    public static final String KEY_STRING = "mystring";

    public PrefManager(){
        super();
    }

    private static SharedPreferences getSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    private static SharedPreferences.Editor getEditor(Context context){
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }


    public static void clear(Context context){
        SharedPreferences.Editor editor = getEditor(context);
        editor.clear();
        editor.apply();
    }


    //lilneee

    public void saveItemSold(Context context, List<ItemSold> itemSolds) {
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(itemSolds);
        editor.putString(KEY_STRING, jsonFavorites);
        editor.apply();
        editor.commit();
    }

    public void removeItemSold(Context context, ItemSold itemSold) {
        ArrayList<ItemSold> listItemSold = getItemSold(context);
        SharedPreferences pref = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        Editor editor = pref.edit();
        editor.remove(KEY_STRING);
        editor.apply();
        if (listItemSold != null) {
            listItemSold.remove(itemSold);
            saveItemSold(context, listItemSold);
        }
    }

    public void clearData(Context context){
        SharedPreferences pref = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public ArrayList<ItemSold> getItemSold(Context context) {
        SharedPreferences settings;
        List<ItemSold> listItemSold;

        settings = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);

        if (settings.contains(KEY_STRING)) {
            String json = settings.getString(KEY_STRING, null);
            Gson gson = new Gson();
            ItemSold[] itemSolds = gson.fromJson(json,
                    ItemSold[].class);

            listItemSold = Arrays.asList(itemSolds);
            listItemSold = new ArrayList<ItemSold>(listItemSold);
        } else
            return null;

        return (ArrayList<ItemSold>) listItemSold;
    }



}
