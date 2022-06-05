package com.example.ecommerce.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ecommerce.model.produit;

public class HelperCart extends SQLiteOpenHelper {

    public HelperCart(@Nullable Context context) {
        super(context, "CartDb", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cart (id integer primary key autoincrement, nom text, prix text, image text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists produit");
        onCreate(db);
    }

    public void deleteAllCart() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from cart");
    }


    public void insertCart(produit produit) {

        ContentValues values = new ContentValues();
        values.put("nom", produit.getNom());
        values.put("prix", produit.getPrix());
        values.put("image", produit.getImage());
        getWritableDatabase().insert("cart", null, values);

    }

    public Cursor getCart() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from cart", null);
        return res;
    }


}
