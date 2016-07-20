package com.app.model;

/**
 * Created by Abdeljalil on 2016-07-19.
 */
public class DciIndication {
    int idDciIndication;
    String nom;

    public DciIndication(int idDciIndication, String nom) {
        this.idDciIndication = idDciIndication;
        this.nom = nom;
    }

    public int getIdDciIndication() {
        return idDciIndication;
    }

    public void setIdDciIndication(int idDciIndication) {
        this.idDciIndication = idDciIndication;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "DciIndication{" +
                "idDciIndication=" + idDciIndication +
                ", nom='" + nom + '\'' +
                '}';
    }
}
