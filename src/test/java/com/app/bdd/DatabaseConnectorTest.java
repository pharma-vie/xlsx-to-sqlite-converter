package com.app.bdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Oussama on 12/07/2016.
 */
public class DatabaseConnectorTest {

    private DatabaseConnector databaseConnector;

    @Before
    public void setUp() throws Exception {
        databaseConnector = new DatabaseConnector();

    }

    @Test
    public void testConnectionToBddFile() throws Exception {
        Assert.assertNotNull( databaseConnector.getConnection() );
    }
}