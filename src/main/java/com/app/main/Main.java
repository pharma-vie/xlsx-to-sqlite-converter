package com.app.main;

import com.app.bdd.DcFamilleOuDci;
import com.app.bdd.DCInteractionMedicamenteuse;
import com.app.bdd.DatabaseConnector;
import com.app.model.FamilleOuDci;
import com.app.model.InteractionMedicamenteuse;
import com.app.model.WhiteFamilleOuDci;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Oussama on 11/07/2016.
 */
public class Main {

    public static DatabaseConnector databaseConnector;
    public static DcFamilleOuDci dcFamilleOuDci;
    public static DCInteractionMedicamenteuse dcInteractionMedicamenteuse;



    public static void main(String[] args) {
        try {
            File file = new File( ClassLoader.getSystemClassLoader().getResource("files/Interactions_medicamenteuses.xlsx").getPath() );

            ArrayList<FamilleOuDci> familleOuDciArrayList = readXLSXFile();
            System.out.println(familleOuDciArrayList.size());

            databaseConnector = new DatabaseConnector();
            dcFamilleOuDci = new DcFamilleOuDci();
            dcInteractionMedicamenteuse = new DCInteractionMedicamenteuse();

          //  insertListIntoDataBase( familleOuDciArrayList );





        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertListIntoDataBase(ArrayList<FamilleOuDci> familleOuDciArrayList) {
        for (FamilleOuDci grayFamilleOuDci : familleOuDciArrayList) {
            //insérer dans la base
            dcFamilleOuDci.addFamilleOuDci( grayFamilleOuDci );

            //avoir son id attribué par sqlite
            grayFamilleOuDci.setId( dcFamilleOuDci.getLastFamilleOuDci().getId() );

            //pour chaque famille en relation avec lui (gray)
            for (WhiteFamilleOuDci whiteFamilleOuDci : grayFamilleOuDci.getListeDeFamillesEnRelationAvec()) {

                //ajouter la famille en relation
                dcFamilleOuDci.addFamilleOuDci(whiteFamilleOuDci);

                //avoir son id attribué par sqlite
                whiteFamilleOuDci.setId( dcFamilleOuDci.getLastFamilleOuDci().getId() );

                //creer un relation
                InteractionMedicamenteuse interactionMedicamenteuse =
                        new InteractionMedicamenteuse(
                        grayFamilleOuDci.getId(),
                        whiteFamilleOuDci.getId(),
                        whiteFamilleOuDci.getLibelleDUneInteraction(),
                        whiteFamilleOuDci.getNiveauContrainteEtDescrption());

                System.out.println( interactionMedicamenteuse.toString() );
                dcInteractionMedicamenteuse.addInteractionMedicamenteuse( interactionMedicamenteuse );


            }
        }
    }

    public static ArrayList<FamilleOuDci> readXLSXFile() throws IOException {

        ArrayList<FamilleOuDci> listeDeFamilleOuDci = new ArrayList<FamilleOuDci>();

        File file = new File( ClassLoader.getSystemClassLoader().getResource("files/Interactions_medicamenteuses.xlsx").getPath() );
        FileInputStream inputStream = new FileInputStream( file );

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        int grayCell = 0;
        boolean lastCellIsGrayCell = false;

        FamilleOuDci lastFamilleOuDci = null;
        WhiteFamilleOuDci lastWhiteFamilleOuDci = null;

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                //test if we are in the grayCell
                if(cell.getCellStyle().getFillForegroundColor() == 0){ // - - -  - - - - - - -  --  - -  Gris
                    grayCell++;
                    System.out.println();

                    //if we are in the cell that has a value (first cell in two cells)
                    if (grayCell % 2 == 1){
                        String cellStr = cell.getStringCellValue();
                        cellStr = cellStr.replaceAll("'", "''");
                        System.out.println( cellStr );

                        if( cellStr.contains("\n")){
                            String nomFamilleOuDci = cellStr.substring( 0, cellStr.indexOf("\n")+1);
                            String description = cellStr.substring( cellStr.indexOf("\n")+1, cellStr.length());
                            nomFamilleOuDci = nomFamilleOuDci.replace("\n", "" );
                            System.out.println( nomFamilleOuDci + " + "+ description );

                            lastFamilleOuDci = new FamilleOuDci(nomFamilleOuDci, description);
                        }else{
                            lastFamilleOuDci = new FamilleOuDci(cellStr, "");
                        }

                        System.out.println( lastFamilleOuDci.toString() );

                        listeDeFamilleOuDci.add( lastFamilleOuDci );

                    }

                }else{                                          //- - - -  - - - - - -  - - - - - white
                    String cellStr = cell.getStringCellValue();
                    cellStr = cellStr.replaceAll("'", "''");

                    if (cellStr.startsWith("+")){
                        cellStr = cellStr.substring( cellStr.indexOf("+")+2, cellStr.length());
                        lastWhiteFamilleOuDci = new WhiteFamilleOuDci(cellStr, "");
                    }else{
                        if(cellStr.length() != 0){
                            if (cell.getColumnIndex() == 0){
                                String libelleDUneInteraction = cellStr;
                                System.out.println( "libelle D' Une Interaction\n" + libelleDUneInteraction );
                                lastWhiteFamilleOuDci.setLibelleDUneInteraction( libelleDUneInteraction );
                            }else{
                                String niveauContrainteEtDescrption = cellStr;
                                System.out.println( "niveau de Contrainte Et sa Descrption\n" + niveauContrainteEtDescrption);
                                lastWhiteFamilleOuDci.setNiveauContrainteEtDescrption( niveauContrainteEtDescrption );

                                System.out.println( lastWhiteFamilleOuDci );
                                listeDeFamilleOuDci.get( listeDeFamilleOuDci.size() -1).getListeDeFamillesEnRelationAvec().add( lastWhiteFamilleOuDci );

                            }

                        }
                    }

                }

            }


        }
            System.out.println( listeDeFamilleOuDci );

        //workbook.close();
        inputStream.close();

        return listeDeFamilleOuDci;
    }




}
