package com.app.bdd;

import com.app.model.InteractionMedicamenteuse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Oussama on 12/07/2016.
 */
public class DCInteractionMedicamenteuseTest {
    @Test
    public void getListOfInteractionMedicamenteuse() throws Exception {
        ArrayList<InteractionMedicamenteuse> interactionMedicamenteuseArrayList = dcInteractionMedicamenteuse.getListOfInteractionMedicamenteuse();
        System.out.println( interactionMedicamenteuseArrayList );
        assertNotEquals(0, interactionMedicamenteuseArrayList.size() );
    }

    @Test
    public void getInteractionMedicamenteuseById() throws Exception {
        InteractionMedicamenteuse interactionMedicamenteuse = dcInteractionMedicamenteuse.getInteractionMedicamenteuseById(1);
        System.out.println( interactionMedicamenteuse.toString() );
        assertNotNull(interactionMedicamenteuse);

    }

    private DCInteractionMedicamenteuse dcInteractionMedicamenteuse;

    @Before
    public void setUp() throws Exception {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        dcInteractionMedicamenteuse = new DCInteractionMedicamenteuse();

    }

    @Test
    public void addInteractionMedicamenteuse() throws Exception {
        InteractionMedicamenteuse interactionMedicamenteuse = new InteractionMedicamenteuse(1, 1, "Risque hbal", "Déconseillé");
        dcInteractionMedicamenteuse.addInteractionMedicamenteuse( interactionMedicamenteuse );
    }

}