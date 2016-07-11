package com.app.model;

/**
 * Created by Oussama on 11/07/2016.
 */
public class WhiteFamilleOuDci extends FamilleOuDci{

    private String libelleDUneInteraction;
    private String niveauContrainteEtDescrption;

    public WhiteFamilleOuDci(String nom, String description) {
        super(nom, description);
    }

    public String getLibelleDUneInteraction() {
        return libelleDUneInteraction;
    }

    public void setLibelleDUneInteraction(String libelleDUneInteraction) {
        this.libelleDUneInteraction = libelleDUneInteraction;
    }

    public String getNiveauContrainteEtDescrption() {
        return niveauContrainteEtDescrption;
    }

    public void setNiveauContrainteEtDescrption(String niveauContrainteEtDescrption) {
        this.niveauContrainteEtDescrption = niveauContrainteEtDescrption;
    }

    @Override
    public String toString() {
        return "WhiteFamilleOuDci{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", listeDeFamillesEnRelationAvec=" + getListeDeFamillesEnRelationAvec() +
                ", libelleDUneInteraction='" + libelleDUneInteraction + '\'' +
                ", niveauContrainteEtDescrption='" + niveauContrainteEtDescrption + '\'' +
                '}';
    }
}
