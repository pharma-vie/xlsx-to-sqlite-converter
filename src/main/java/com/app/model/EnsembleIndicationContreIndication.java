package com.app.model;

/**
 * Created by Abdeljalil on 2016-07-19.
 */
public class EnsembleIndicationContreIndication {
    int idEnsembleIndicationContreIndication;
    int idDciIndication;
    int idIndicationContreIndication;



    public EnsembleIndicationContreIndication( int idDciIndication, int idIndicationContreIndication) {
        this.idDciIndication = idDciIndication;
        this.idIndicationContreIndication = idIndicationContreIndication;


    }

    public int getIdEnsembleIndicationContreIndication() {
        return idEnsembleIndicationContreIndication;
    }

    public void setIdEnsembleIndicationContreIndication(int idEnsembleIndicationContreIndication) {
        this.idEnsembleIndicationContreIndication = idEnsembleIndicationContreIndication;
    }

    public int getIdDciIndication() {
        return idDciIndication;
    }

    public void setIdDciIndication(int idDciIndication) {
        this.idDciIndication = idDciIndication;
    }

    public int getIdIndicationContreIndication() {
        return idIndicationContreIndication;
    }

    public void setIdIndicationContreIndication(int idIndicationContreIndication) {
        this.idIndicationContreIndication = idIndicationContreIndication;
    }


    @Override
    public String toString() {
        return "EnsembleIndicationContreIndication{" +
                "idEnsembleIndicationContreIndication=" + idEnsembleIndicationContreIndication +
                ", idDciIndication=" + idDciIndication +
                ", idIndicationContreIndication=" + idIndicationContreIndication +
                '}';
    }
}
