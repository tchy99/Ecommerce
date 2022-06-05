package com.example.ecommerce.api;

import android.content.ContentValues;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ecommerce.model.produit;

public class Helper extends SQLiteOpenHelper {

    public Helper(android.content.Context context) {
        super(context, "ecommerce", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table produit (id integer primary key autoincrement, nom text, description text, prix text, image text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists produit");
        onCreate(db);
    }



    public void deleteAllProduit() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from produit");

    }

    public void insertProduit(Post post) {

        ContentValues values = new ContentValues();
        values.put("nom", post.getTitle());
        values.put("description", post.getDescription());
        values.put("prix", post.getPrice());
        values.put("image", post.getImage());
        getWritableDatabase().insert("produit", null, values);

    }




    public void updateProduit(Post post) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update produit set nom = '" + post.getTitle() + "', description = '" + post.getDescription() + "', prix = '" + post.getPrice() + "', image = '" + post.getImage() + "' where id = " + post.getId());
        db.close();
    }

    public Cursor getProduit() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from produit", null);
        return res;
    }

    public produit[] getAllProduit() {
        Cursor res = getProduit();
        produit[] produits = new produit[res.getCount()];
        int i = 0;
        while (res.moveToNext()) {
            produits[i] = new produit(res.getInt(0), res.getString(1), res.getString(2), res.getString(3), res.getString(4));
            i++;
        }
        return produits;
    }
}

