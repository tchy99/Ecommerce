package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.model.produit;
import com.example.ecommerce.view.CartAdapter;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    TextView textViewNom;
    TextView textViewPrix;
    TextView textViewDescription;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        String nom = getIntent().getStringExtra("Nom");
        String prix = getIntent().getStringExtra("Prix");
        String image = getIntent().getStringExtra("Image");





        ArrayList<produit> list = new ArrayList<produit>();
        list.add(new produit(1,nom,"description",prix,image));


        // get listview
        ListView listView = (ListView) findViewById(R.id.cart_view);
        listView.setAdapter(new CartAdapter(this,list));


        for (int i = 0; i < list.size(); i++) {
//            textViewNom.setText(list.get(i).getNom());
            textViewPrix.append(list.get(i).getPrix()+ " USD\n");
//            Glide.with(this).load(list.get(i).getImage()).into(imageView);
        }


    }
}