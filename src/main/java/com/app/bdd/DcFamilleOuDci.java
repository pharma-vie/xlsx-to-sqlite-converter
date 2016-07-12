package com.app.bdd;

import com.app.model.FamilleOuDci;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Oussama on 12/07/2016.
 */
public class DCFamilleOuDci extends DatabaseConnector{


    public void addFamilleOuDci(FamilleOuDci familleOuDci){

        //language=SQLite
        String requeteSql = "INSERT INTO FamilleOuDci (nomFamilleOuDci, description) VALUES ('"+
                familleOuDci.getNom()+"','"+
                familleOuDci.getDescription()+"');";

        excuteVoidQuery( requeteSql );
    }

    public FamilleOuDci getFamilleOuDciById( int idFamilleOuDci){
        FamilleOuDci resultat = null;

        //language=SQLite
        String requeteSql = "SELECT * FROM FamilleOuDci WHERE idNomFamilleOuDci = "+ idFamilleOuDci;

        ResultSet resultSet = executeGetQuery( requeteSql );

        ArrayList<FamilleOuDci> listFamilleOuDci = getListOfFamilleOuDciFromResultSet( resultSet );

        resultat = listFamilleOuDci.get(0);

        return resultat;
    }

    public ArrayList<FamilleOuDci> getListOfFamilleOuDci(){
        ArrayList<FamilleOuDci> resultat;

        //language=SQLite
        String requeteSql = "SELECT * FROM FamilleOuDci";

        ResultSet resultSet = executeGetQuery( requeteSql );

        resultat = getListOfFamilleOuDciFromResultSet( resultSet );

        return resultat;
    }

    private ArrayList<FamilleOuDci> getListOfFamilleOuDciFromResultSet(ResultSet resultSet) {
        ArrayList<FamilleOuDci> resultat = new ArrayList<FamilleOuDci>();

        try {

            while (resultSet.next()) {
                int idNomFamilleOuDci = resultSet.getInt( "idNomFamilleOuDci" );
                String nomFamilleOuDci = resultSet.getString( "nomFamilleOuDci" );
                String description = resultSet.getString( "description" );

                FamilleOuDci familleOuDci = new FamilleOuDci(idNomFamilleOuDci, nomFamilleOuDci, description);
                resultat.add( familleOuDci );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultat;
    }

    public FamilleOuDci getLastFamilleOuDci(){
        FamilleOuDci resultat = null;

        //language=SQLite
        String requeteSql = "SELECT * FROM FamilleOuDci WHERE idNomFamilleOuDci = (SELECT MAX(idNomFamilleOuDci) FROM FamilleOuDci)";

        ResultSet resultSet = executeGetQuery( requeteSql );

        ArrayList<FamilleOuDci> listFamilleOuDci = getListOfFamilleOuDciFromResultSet( resultSet );

        resultat = listFamilleOuDci.get(0);

        return resultat;
    }

    public void deleteFamilleOuDci( FamilleOuDci familleOuDci){
        //language=SQLite
        String requeteSql = "DELETE FROM FamilleOuDci WHERE idNomFamilleOuDci = "+ familleOuDci.getId();

        excuteVoidQuery( requeteSql );
    }

}
