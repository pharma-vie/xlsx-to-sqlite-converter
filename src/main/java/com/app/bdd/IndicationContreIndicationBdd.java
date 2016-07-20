package com.app.bdd;

import com.app.model.DciIndication;
import com.app.model.EnsembleIndicationContreIndication;
import com.app.model.FamilleOuDci;
import com.app.model.IndicationContreIndication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Abdeljalil on 2016-07-19.
 */
public class IndicationContreIndicationBdd extends DatabaseConnector {

    public void AddDciIndication(DciIndication DciIndication ){
        String requeteSql = "INSERT INTO DciIndication (idDciIndication, nom) VALUES ('"+
                DciIndication.getIdDciIndication()+"','"+
                DciIndication.getNom()+"');";

        excuteVoidQuery( requeteSql );
    }

    public void AddIndicationContreIndication(IndicationContreIndication IndicationContreIndication){
        String requeteSql = "INSERT INTO IndicationContreIndication (idIndicationContreIndication, ActionTherapeutique, Indication, ContreIndication) VALUES ('"+
                IndicationContreIndication.getIdIndicationContreIndication()+"','"+
                IndicationContreIndication.getActionTherapeutique()+"','"+
                IndicationContreIndication.getIndication()+"','"+
                IndicationContreIndication.getContreIndication()+"');";

        excuteVoidQuery( requeteSql );
    }

    public void AddEnsembleIndicationContreIndication(EnsembleIndicationContreIndication EnsembleIndicationContreIndication){
        String requeteSql = "INSERT INTO EnsembleIndicationContreIndication ( idDciIndication, idIndicationContreIndication) VALUES ('"+
                EnsembleIndicationContreIndication.getIdDciIndication()+"','"+
                EnsembleIndicationContreIndication.getIdIndicationContreIndication()+"');";

        excuteVoidQuery( requeteSql );
    }



    ArrayList<IndicationContreIndication> getIndicationContreIndicationResultSet(ResultSet resultSet) {
        ArrayList<IndicationContreIndication> resultat = new ArrayList<IndicationContreIndication>();

        try {

            while (resultSet.next()) {
                int idIndicationContreIndication = resultSet.getInt( "idIndicationContreIndication" );
                String ActionTherapeutique = resultSet.getString( "ActionTherapeutique" );
                String Indication = resultSet.getString( "Indication" );
                String ContreIndication = resultSet.getString( "ContreIndication" );

                IndicationContreIndication IndicationContreIndication = new IndicationContreIndication(idIndicationContreIndication, ActionTherapeutique, Indication, ContreIndication);
                resultat.add( IndicationContreIndication );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultat;
    }


}
