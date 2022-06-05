package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ecommerce.api.Helper;
import com.example.ecommerce.api.HelperCart;
import com.example.ecommerce.api.Post;
import com.example.ecommerce.model.produit;
import com.example.ecommerce.view.CartAdapter;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    TextView textViewN;
    TextView textViewP;
    ImageView imageV;
    Button button;

    HelperCart helperCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
         helperCart = new HelperCart(this);
        String nom = getIntent().getStringExtra("Nom");
        String prix = getIntent().getStringExtra("Prix");
        String image = getIntent().getStringExtra("Image");

        textViewN= findViewById(R.id.item_title);
        textViewP = findViewById(R.id.item_price);
        imageV = findViewById(R.id.image);
        button = findViewById(R.id.peye);
//        Toast.makeText(this, nom, Toast.LENGTH_SHORT).show();
//        helperCart.deleteAllCart();

        ArrayList<produit> list = new ArrayList<produit>();
        ArrayList<produit> list1 = new ArrayList<produit>();

        list.add(new produit(1,nom,"description",prix,image));



        Cursor cursor = helperCart.getCart();



        for (produit produit : list) {
            helperCart.insertCart(produit);
        }

        while (cursor.moveToNext()) {
            String nom1 = cursor.getString(1);
            String prix1 = cursor.getString(2);
            String image1 = cursor.getString(3);
            list1.add(new produit(1,nom1,"description",prix1,image1));

        }












        // get listview
        ListView listView = (ListView) findViewById(R.id.cart_view);
        listView.setAdapter(new CartAdapter(this,list1));



    }
}