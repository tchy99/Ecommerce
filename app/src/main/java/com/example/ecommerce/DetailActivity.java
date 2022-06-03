package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView textViewNom;
    TextView textViewPrix;
    TextView textViewDescription;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String nom = getIntent().getStringExtra("Nom");
        String prix = getIntent().getStringExtra("Prix");
        String description = getIntent().getStringExtra("Description");
        String image = getIntent().getStringExtra("Image");

        textViewNom = findViewById(R.id.id_nom);
        textViewPrix = findViewById(R.id.id_price);
        textViewDescription = findViewById(R.id.id_description);
        imageView = findViewById(R.id.imageView);

        textViewNom.setText(nom);
        textViewPrix.setText(prix);
        textViewDescription.setText(description);
        Glide.with(this).load(image).into(imageView);


    }
}