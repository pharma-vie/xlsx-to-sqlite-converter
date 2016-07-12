package com.app.model;

/**
 * Created by Oussama on 12/07/2016.
 */
public class InteractionMedicamenteuse {

    private int idInteractionMedicamenteuse;
    private int idNomFamilleOuDci;
    private int idNomSousFamilleOuDci;
    private String libelleDUneInteraction;
    private String niveauContrainteEtDescrption;

    public InteractionMedicamenteuse(int idInteractionMedicamenteuse, int idNomFamilleOuDci, int idNomSousFamilleOuDci, String libelleDUneInteraction, String niveauContrainteEtDescrption) {
        this.idInteractionMedicamenteuse = idInteractionMedicamenteuse;
        this.idNomFamilleOuDci = idNomFamilleOuDci;
        this.idNomSousFamilleOuDci = idNomSousFamilleOuDci;
        this.libelleDUneInteraction = libelleDUneInteraction;
        this.niveauContrainteEtDescrption = niveauContrainteEtDescrption;
    }

    public InteractionMedicamenteuse(int idNomFamilleOuDci, int idNomSousFamilleOuDci, String libelleDUneInteraction, String niveauContrainteEtDescrption) {
        this.idNomFamilleOuDci = idNomFamilleOuDci;
        this.idNomSousFamilleOuDci = idNomSousFamilleOuDci;
        this.libelleDUneInteraction = libelleDUneInteraction;
        this.niveauContrainteEtDescrption = niveauContrainteEtDescrption;
    }

    public int getIdInteractionMedicamenteuse() {
        return idInteractionMedicamenteuse;
    }

    public void setIdInteractionMedicamenteuse(int idInteractionMedicamenteuse) {
        this.idInteractionMedicamenteuse = idInteractionMedicamenteuse;
    }

    public int getIdNomFamilleOuDci() {
        return idNomFamilleOuDci;
    }

    public void setIdNomFamilleOuDci(int idNomFamilleOuDci) {
        this.idNomFamilleOuDci = idNomFamilleOuDci;
    }

    public int getIdNomSousFamilleOuDci() {
        return idNomSousFamilleOuDci;
    }

    public void setIdNomSousFamilleOuDci(int idNomSousFamilleOuDci) {
        this.idNomSousFamilleOuDci = idNomSousFamilleOuDci;
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
        return "InteractionMedicamenteuse{" +
                "idInteractionMedicamenteuse=" + idInteractionMedicamenteuse +
                ", idNomFamilleOuDci=" + idNomFamilleOuDci +
                ", idNomSousFamilleOuDci=" + idNomSousFamilleOuDci +
                ", libelleDUneInteraction='" + libelleDUneInteraction + '\'' +
                ", niveauContrainteEtDescrption='" + niveauContrainteEtDescrption + '\'' +
                '}';
    }
}
