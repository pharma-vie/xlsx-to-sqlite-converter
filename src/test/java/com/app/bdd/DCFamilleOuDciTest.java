package com.app.bdd;

import com.app.model.FamilleOuDci;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Oussama on 12/07/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DCFamilleOuDciTest {
    @Test
    public void testE_deleteFamilleOuDci() throws Exception {
        FamilleOuDci familleOuDci = dcFamilleOuDci.getLastFamilleOuDci();
        dcFamilleOuDci.deleteFamilleOuDci( familleOuDci );
    }

    @Test
    public void testD_getLastFamilleOuDciBy() throws Exception {
        FamilleOuDci familleOuDci = dcFamilleOuDci.getLastFamilleOuDci();
        System.out.println( familleOuDci.toString() );
        assertNotNull( familleOuDci );
    }

    @Test
    public void testC_getListOfFamilleOuDci() throws Exception {
        ArrayList<FamilleOuDci> familleOuDciArrayList = dcFamilleOuDci.getListOfFamilleOuDci();
        System.out.println( familleOuDciArrayList );
        assertNotEquals(0, familleOuDciArrayList.size());
    }

    private DCFamilleOuDci dcFamilleOuDci;

    @Before
    public void setUp() throws Exception {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        dcFamilleOuDci = new DCFamilleOuDci();

    }

    @Test
    public void testA_addFamilleOuDci() throws Exception {
        FamilleOuDci familleOuDci = new FamilleOuDci("PENICILINE", "(fddfd), (dfdfdf)");
        dcFamilleOuDci.addFamilleOuDci( familleOuDci );
    }


    @Test
    public void testB_getFamilleOuDciById() throws Exception {
        FamilleOuDci familleOuDci = dcFamilleOuDci.getFamilleOuDciById(1);
        System.out.println( familleOuDci );
        assertNotNull(familleOuDci);
    }

    @After
    public void tearDown() throws Exception {


    }
}