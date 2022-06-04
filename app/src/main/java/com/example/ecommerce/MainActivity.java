package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ecommerce.api.Helper;
import com.example.ecommerce.api.JsonPlaceHolderApi;
import com.example.ecommerce.api.Post;
import com.example.ecommerce.model.produit;
import com.example.ecommerce.view.ProduitAdapter;
import com.example.ecommerce.view.RecyclerViewInterface;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
        NavigationView navigationView;
        ActionBarDrawerToggle actionBarDrawerToggle;
        DrawerLayout drawerLayout;
        Toolbar toolbar;
        RecyclerView recyclerView;

        //Données
        List<produit> list_produit= new ArrayList<produit>();

        Helper helper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            helper = new Helper(this);
            // Retrofit Builder
            retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("https://fakestoreapi.com/")
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .build();
            // Retrofit Service
            JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

            Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

            call.enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(Call<List<Post>> call, retrofit2.Response<List<Post>> response) {
                    if (!response.isSuccessful()) {
                        return;
                    }
                    List<Post> posts = response.body();

                    helper.deleteAllProduit();                    for (Post post : posts) {
                        helper.insertProduit(post);
                    }



                }


                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {

                }
            });



            for (produit produit : helper.getAllProduit()) {
                list_produit.add(produit);
            }


            recyclerView = (RecyclerView) findViewById(R.id.rv);
            //Création de l'adapter qui utilisera notre liste
            ProduitAdapter produitAdapter = new ProduitAdapter((ArrayList<produit>) list_produit, this,this);

            //On demande au RecycleView d'utiliser notre adapter
            recyclerView.setAdapter(produitAdapter);

            //On indique que notre RecyclerView utilise un LinearLayoutManager
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            navigationView = findViewById(R.id.navview);
            drawerLayout = findViewById(R.id.drawer);

            //adding customised toolbar
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);



            actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout,toolbar,R.string.open,R.string.close);
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();


            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId())
                    {
                        case R.id.home:
                            Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                            //close drawer
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;

                        case R.id.profile:
                            Toast.makeText(getApplicationContext(),"Profile",Toast.LENGTH_SHORT).show();
                            //close drawer
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;

                        case R.id.settings:
                            Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
                            //close drawer
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;

                        case R.id.privacy:
                            Toast.makeText(getApplicationContext(),"Privacy",Toast.LENGTH_SHORT).show();
                            //close drawer
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;


                    }

                    return true;
                }
            });


    }




    @Override
    public void onClick(int position) {
        Intent detailIntent = new Intent(MainActivity.this,  DetailActivity.class);
        detailIntent.putExtra("Nom",  list_produit.get(position).getNom());
        detailIntent.putExtra("Description",  list_produit.get(position).getDescription());
        detailIntent.putExtra("Prix",  list_produit.get(position).getPrix());
        detailIntent.putExtra("Image",  list_produit.get(position).getImage());
        startActivity(detailIntent);
    }


}