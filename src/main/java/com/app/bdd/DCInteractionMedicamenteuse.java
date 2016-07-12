package com.app.bdd;

import com.app.model.InteractionMedicamenteuse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Oussama on 12/07/2016.
 */
public class DCInteractionMedicamenteuse extends DatabaseConnector {

    public void addInteractionMedicamenteuse(InteractionMedicamenteuse interactionMedicamenteuse){

        //language=SQLite
        String requeteSql = "INSERT INTO InteractionMedicamenteuse (idNomFamilleOuDci, idNomSousFamilleOuDci, libelleDUneInteraction, niveauContrainteEtDescrption) VALUES (" +
                interactionMedicamenteuse.getIdNomFamilleOuDci()+", " +
                interactionMedicamenteuse.getIdNomSousFamilleOuDci()+", '" +
                interactionMedicamenteuse.getLibelleDUneInteraction()+"', '" +
                interactionMedicamenteuse.getNiveauContrainteEtDescrption()+"') ";

        excuteVoidQuery( requeteSql );
    }

    public InteractionMedicamenteuse getInteractionMedicamenteuseById(int idInteractionMedicamenteuse){
        InteractionMedicamenteuse resultat = null;

        //language=SQLite
        String requeteSql = "SELECT * FROM InteractionMedicamenteuse WHERE idInteractionMedicamenteuse = "+ idInteractionMedicamenteuse;

        ResultSet resultSet = executeGetQuery( requeteSql );

        ArrayList<InteractionMedicamenteuse> listInteractionMedicamenteuse = getListOfInteractionMedicamenteuseFromResultSet( resultSet );

        resultat = listInteractionMedicamenteuse.get(0);

        return resultat;
    }

    public ArrayList<InteractionMedicamenteuse> getListOfInteractionMedicamenteuse(){
        ArrayList<InteractionMedicamenteuse> resultat;

        //language=SQLite
        String requeteSql = "SELECT * FROM InteractionMedicamenteuse";

        ResultSet resultSet = executeGetQuery( requeteSql );

        resultat = getListOfInteractionMedicamenteuseFromResultSet( resultSet );

        return resultat;
    }


    private ArrayList<InteractionMedicamenteuse> getListOfInteractionMedicamenteuseFromResultSet(ResultSet resultSet) {
        ArrayList<InteractionMedicamenteuse> resultat = new ArrayList<InteractionMedicamenteuse>();

        try {

            while (resultSet.next()) {
                int idInteractionMedicamenteuse = resultSet.getInt( "idInteractionMedicamenteuse" );
                int idNomFamilleOuDci = resultSet.getInt( "idNomFamilleOuDci" );
                int idNomSousFamilleOuDci = resultSet.getInt( "idNomSousFamilleOuDci" );
                String libelleDUneInteraction = resultSet.getString( "libelleDUneInteraction" );
                String niveauContrainteEtDescrption = resultSet.getString( "niveauContrainteEtDescrption" );

                InteractionMedicamenteuse interactionMedicamenteuse = new InteractionMedicamenteuse(idInteractionMedicamenteuse, idNomFamilleOuDci, idNomSousFamilleOuDci, libelleDUneInteraction, niveauContrainteEtDescrption);
                resultat.add( interactionMedicamenteuse );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultat;
    }


}
