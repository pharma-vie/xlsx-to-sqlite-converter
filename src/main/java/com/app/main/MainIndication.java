package com.app.main;

import com.app.bdd.IndicationContreIndicationBdd;
import com.app.model.DciIndication;
import com.app.model.EnsembleIndicationContreIndication;
import com.app.model.IndicationContreIndication;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.dom4j.DocumentException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Abdeljalil on 2016-07-19.
 */
public class MainIndication {

    public static IndicationContreIndicationBdd IndicationContreIndicationBdd;


    public static void main(String[] args) throws IOException, DocumentException {
        String condition = "Contre-indications, effets indésirables, précautions";
        String condition1 = "Prescription sous contrôle médical";
        String condition2 = "Action thérapeutique";
        String condition3 = "En raison de la fréquence des souches de P.";
        String condition4 = "L'usage de ce médicament est déconseillé";
        String condition5 = "Des effets cancérogènes ont été démontrés lors";
        String condition6 = "L’usage des";
        String condition7 = "Le sérum antitétanique hétérologue ne doit plus être employé en raison";


        PdfReader reader = new PdfReader("/Users/user/Downloads/PdfReader/src/recourses/medicalC.pdf");
        int NombrePage = reader.getNumberOfPages();
        int count = 0;
        IndicationContreIndicationBdd = new IndicationContreIndicationBdd();
        DciIndication DciIndication = null;
        EnsembleIndicationContreIndication EnsembleIndicationContreIndication = null;
        IndicationContreIndication IndicationContreIndication = null;

        for (int i = 1; i <= NombrePage; i++) {
            String page = PdfTextExtractor.getTextFromPage(reader, i);
            BufferedReader bufReader = new BufferedReader(new StringReader(page));
            String DCI = "";


            String line = null;

            // La boucle permet l'extraction du DCI [en tete de la page]
            while ((line = bufReader.readLine()) != null) {
                if (line.startsWith(condition) || line.startsWith(condition1) || line.startsWith(condition2)
                        || line.startsWith(condition3) || line.startsWith(condition4) || line.startsWith(condition5) || line.startsWith(condition6)
                        || line.startsWith(condition7) || line.startsWith("–") || line.startsWith("Précautions") || line.matches("[1-5]+")) {
                    break;
                } else {
                    DCI = DCI + line;
                }

            }
            // Extraction des indications et contre indications et ajouter a la base de donnee
            if (DCI.length() != 0) {
                count = count + 1;
                DCI = DCI.replaceAll("\n", " ");
                DCI = DCI.replaceAll("'", "''");

                String ActionTherpeutique = getActionTherpeutique(page).replaceAll("'", "''");
                String Indication = getIndication(page).replaceAll("'", "''");
                String ContreIndication = getContreIndication(page).replaceAll("'", "''");

//                System.out.println("DCI " + count + " :" + DCI);
//                System.out.println(" Action thérapeutique :" + ActionTherpeutique);
//                System.out.println(" Indications :" + Indication);
//                System.out.println(" Contre Indication  :" + ContreIndication);
//
                DciIndication = new DciIndication(count, DCI);
                IndicationContreIndicationBdd.AddDciIndication(DciIndication);

                IndicationContreIndication = new IndicationContreIndication(count, ActionTherpeutique, Indication, ContreIndication);
                IndicationContreIndicationBdd.AddIndicationContreIndication(IndicationContreIndication);

                EnsembleIndicationContreIndication = new EnsembleIndicationContreIndication(DciIndication.getIdDciIndication(), IndicationContreIndication.getIdIndicationContreIndication());
                IndicationContreIndicationBdd.AddEnsembleIndicationContreIndication(EnsembleIndicationContreIndication);
            }
        }
    }

    public static String getActionTherpeutique(String page) {
        String resultat = "";
        if (page.contains("Action thérapeutique")) {
            resultat = page.substring(page.indexOf("Action thérapeutique") + "Action thérapeutique".length(), page.length());
            resultat = resultat.substring(0, resultat.indexOf("Indications"));
        }
        return resultat;
    }

    public static String getIndication(String page) {
        String resultat = "";
        resultat = page.substring(page.indexOf("Indications") + "Indications".length(), page.length());
        if (resultat.indexOf("Présentation") != -1)
            resultat = resultat.substring(0, resultat.indexOf("Présentation"));
        else {
            if (resultat.indexOf("Composition et présentation") != -1)
                resultat = resultat.substring(0, resultat.indexOf("Composition et présentation"));
            else {
                if (resultat.indexOf("Durée") != -1)
                    resultat = resultat.substring(0, resultat.indexOf("Durée"));
                else
                    resultat = resultat.substring(0, resultat.indexOf("Composition, présentation et voie d'administration"));
            }
        }
        return resultat;
    }

    public static String getContreIndication(String page) {
        String resultat = "";
        String type = "Contre-indications, effets indésirables, précautions";
        if (page.contains(type)) {
            resultat = page.substring(page.indexOf(type) + type.length(), page.length());
            resultat = resultat.substring(0, resultat.indexOf("Remarques"));
        }
        return resultat;
    }

}
