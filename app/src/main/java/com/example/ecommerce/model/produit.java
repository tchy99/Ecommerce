package com.example.ecommerce.model;

public class produit {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String nom;
    private String description;
    private String prix;
    private String image;

    public produit(int id,String nom, String description, int prix, String image) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = String.valueOf(prix);
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

