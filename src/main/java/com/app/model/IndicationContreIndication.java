package com.app.model;

/**
 * Created by Abdeljalil on 2016-07-19.
 */
public class IndicationContreIndication {
    int idIndicationContreIndication;

    public IndicationContreIndication(String actionTherapeutique, String indication, String contreIndication) {
        ActionTherapeutique = actionTherapeutique;
        Indication = indication;
        ContreIndication = contreIndication;
    }

    String ActionTherapeutique;
    String Indication;
    String ContreIndication;

    public IndicationContreIndication(int idIndicationContreIndication, String actionTherapeutique, String indication, String contreIndication) {
        this.idIndicationContreIndication = idIndicationContreIndication;
        ActionTherapeutique = actionTherapeutique;
        Indication = indication;
        ContreIndication = contreIndication;
    }

    public int getIdIndicationContreIndication() {
        return idIndicationContreIndication;
    }

    public void setIdIndicationContreIndication(int idIndicationContreIndication) {
        this.idIndicationContreIndication = idIndicationContreIndication;
    }

    public String getIndication() {
        return Indication;
    }

    public void setIndication(String indication) {
        Indication = indication;
    }

    public String getContreIndication() {
        return ContreIndication;
    }

    public void setContreIndication(String contreIndication) {
        ContreIndication = contreIndication;
    }

    public String getActionTherapeutique() {
        return ActionTherapeutique;
    }

    public void setActionTherapeutique(String actionTherapeutique) {
        ActionTherapeutique = actionTherapeutique;
    }

    @Override
    public String toString() {
        return "IndicationContreIndication{" +
                "idIndicationContreIndication=" + idIndicationContreIndication +
                ", Indication='" + Indication + '\'' +
                ", ContreIndication='" + ContreIndication + '\'' +
                ", ActionTherapeutique='" + ActionTherapeutique + '\'' +
                '}';
    }
}
