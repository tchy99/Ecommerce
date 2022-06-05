package com.example.ecommerce.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;
import com.example.ecommerce.model.produit;

import java.util.ArrayList;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitAdapter.ViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<produit> arraylist;




    public ProduitAdapter(ArrayList<produit> arraylist, Context context,  RecyclerViewInterface recyclerViewInterface) {
        this.arraylist = arraylist;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.ligne_produit, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        produit produit = arraylist.get(position);

        holder.textViewNom.setText(produit.getNom());
        String res = produit.getDescription().substring(0, 40);
        holder.textViewDescription.setText(res + "...");
        holder.textViewPrix.setText(produit.getPrix()+ " USD");
        Glide.with(this.context).load(produit.getImage()).into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewNom;
        public TextView textViewDescription;
        public TextView textViewPrix;
        public View root;
        public Button button;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_produit);
            textViewNom = itemView.findViewById(R.id.nom_produit);
            textViewDescription = itemView.findViewById(R.id.description_produit);
            textViewPrix = itemView.findViewById(R.id.prix_produit);
            button = itemView.findViewById(R.id.add);
            root = itemView.findViewById(R.id.root);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewInterface.onClickButton(getAdapterPosition());
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        recyclerViewInterface.onClick(getAdapterPosition());
                    }
                }
            });
        }
    }


}
