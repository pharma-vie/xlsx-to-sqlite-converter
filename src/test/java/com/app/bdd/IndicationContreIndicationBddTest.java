package com.app.bdd;

import com.app.model.DciIndication;
import com.app.model.EnsembleIndicationContreIndication;
import com.app.model.FamilleOuDci;
import com.app.model.IndicationContreIndication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Abdeljalil on 2016-07-20.
 */
public class IndicationContreIndicationBddTest  extends DatabaseConnector{
    IndicationContreIndicationBdd IndicationContreIndicationBdd;
    @Before
    public void setUp() throws Exception {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        IndicationContreIndicationBdd = new IndicationContreIndicationBdd();

    }

    @Test
    public void testAddDciIndication() {
        DciIndication DciIndication = new DciIndication(777,"DciIndication");
        IndicationContreIndicationBdd.AddDciIndication(DciIndication);
    }


    @Test
    public void testAddIndicationContreIndication(){
        IndicationContreIndication IndicationContreIndication = new IndicationContreIndication("action", "indication test", "contre indication test");
        IndicationContreIndicationBdd.AddIndicationContreIndication(IndicationContreIndication);
    }

    @Test
    public void testAddEnsembleIndicationContreIndication(){
        EnsembleIndicationContreIndication EnsembleIndicationContreIndication = new EnsembleIndicationContreIndication(23, 55);
        IndicationContreIndicationBdd.AddEnsembleIndicationContreIndication(EnsembleIndicationContreIndication);
    }


    @Test
    public void testRechercheIndicationContreIndication(){



        IndicationContreIndication resultat = null;

        //language=SQLite
        String requeteSql = " SELECT *\n" +
                "                FROM IndicationContreIndication\n" +
                "        WHERE idIndicationContreIndication IN\n" +
                "\n" +
                "                (SELECT idIndicationContreIndication\n" +
                "                        FROM EnsembleIndicationContreIndication\n" +
                "                        WHERE idDciIndication IN\n" +
                "\n" +
                "                                (SELECT idDciIndication\n" +
                "                                        FROM DciIndication\n" +
                "                                        WHERE nom LIKE '%Laroxyl®%')\n" +
                "        )";

        ResultSet resultSet = executeGetQuery( requeteSql );
        ArrayList<IndicationContreIndication> IndicationContreIndication = IndicationContreIndicationBdd.getIndicationContreIndicationResultSet(resultSet);
        System.out.println( IndicationContreIndication );

    }

    @After
    public void tearDown() throws Exception {


    }

}