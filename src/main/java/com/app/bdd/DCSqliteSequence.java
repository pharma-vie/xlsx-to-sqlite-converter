package com.app.bdd;

import com.app.model.SqlSequenceElement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Oussama on 12/07/2016.
 */
public class DCSqliteSequence extends DatabaseConnector {

    public SqlSequenceElement getSqlSequenceElementByName( String name){
        SqlSequenceElement resultat;

        //language=SQLite
        String requeteSql = "SELECT * FROM sqlite_sequence WHERE name = '"+ name +"'";

        ResultSet resultSet = executeGetQuery( requeteSql );

        ArrayList<SqlSequenceElement> listSqlSequenceElement = getListOfSqlSequenceElementFromResultSet( resultSet );

        resultat = listSqlSequenceElement.get(0);

        return resultat;

    }

    public void updateSqlSequenceElement(SqlSequenceElement oldSqlSequenceElement, SqlSequenceElement newSqlSequenceElement){
        //language=SQLite
        String requeteSql = "UPDATE sqlite_sequence SET seq = "+
                newSqlSequenceElement.getSeq()+" WHERE name = '"+
                oldSqlSequenceElement.getName()+"' ";

        excuteVoidQuery( requeteSql );
    }

    private ArrayList<SqlSequenceElement> getListOfSqlSequenceElementFromResultSet(ResultSet resultSet) {
        ArrayList<SqlSequenceElement> resultat = new ArrayList<>();

        try {

            while (resultSet.next()) {
                String name = resultSet.getString( "name" );
                int seq = resultSet.getInt( "seq" );

                SqlSequenceElement sqlSequenceElement = new SqlSequenceElement(name, seq);
                resultat.add( sqlSequenceElement );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultat;
    }

}
