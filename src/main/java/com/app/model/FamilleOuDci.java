package com.app.model;

import java.util.ArrayList;

/**
 * Created by Oussama on 11/07/2016.
 */
public class FamilleOuDci {

    private int id;
    private String nom;
    private String description;
    private ArrayList<FamilleOuDci> listeDeFamillesEnRelationAvec;

    public FamilleOuDci(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.listeDeFamillesEnRelationAvec = new ArrayList<FamilleOuDci>();
    }

    public FamilleOuDci(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<FamilleOuDci> getListeDeFamillesEnRelationAvec() {
        return listeDeFamillesEnRelationAvec;
    }

    public void setListeDeFamillesEnRelationAvec(ArrayList<FamilleOuDci> listeDeFamillesEnRelationAvec) {
        this.listeDeFamillesEnRelationAvec = listeDeFamillesEnRelationAvec;
    }

    @Override
    public String toString() {
        return "FamilleOuDci{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", listeDeFamillesEnRelationAvec=" + listeDeFamillesEnRelationAvec +
                '}';
    }
}
