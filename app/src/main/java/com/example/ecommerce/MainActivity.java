package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ecommerce.model.produit;
import com.example.ecommerce.view.ProduitAdapter;
import com.google.android.material.navigation.NavigationView;
import com.example.ecommerce.model.produit;
import com.example.ecommerce.model.produit;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        NavigationView navigationView;
        ActionBarDrawerToggle actionBarDrawerToggle;
        DrawerLayout drawerLayout;
        Toolbar toolbar;
        RecyclerView recyclerView;

        ProduitAdapter adapt;

        //Données
        ArrayList<produit> produit;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            navigationView = findViewById(R.id.navview);
            drawerLayout = findViewById(R.id.drawer);

            //adding customised toolbar
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);



            actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout,toolbar,R.string.open,R.string.close);
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
//            produit = new ArrayList<>();
//            produit p = new produit(1,"polo","bel mayo",12,"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");
//
//
//            //Création d'une collection d'élèves
//
////
//            //Création de l'adapter qui utilisera notre liste
//            adapt = new ProduitAdapter(produit, this);
////
//            //On lie l'adapter à la liste
//            recyclerView.setAdapter(adapt);
//
//            recyclerView.setLayoutManager(new LinearLayoutManager(this));
////            when an item is selected from menu
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
}