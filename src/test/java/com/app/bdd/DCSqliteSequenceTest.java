package com.app.bdd;

import com.app.model.SqlSequenceElement;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Oussama on 12/07/2016.
 */
public class DCSqliteSequenceTest {

    private DCSqliteSequence  dcSqliteSequence;

    @Before
    public void setUp() throws Exception {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        dcSqliteSequence = new DCSqliteSequence();

    }

    @Test
    public void getSqlSequenceElementByName() throws Exception {
        SqlSequenceElement sqlSequenceElement = dcSqliteSequence.getSqlSequenceElementByName("Medicament");
        System.out.println( sqlSequenceElement.toString() );
        assertNotNull( sqlSequenceElement );
    }

}