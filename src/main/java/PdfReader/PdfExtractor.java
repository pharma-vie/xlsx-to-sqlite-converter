package PdfReader;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Abdeljalil on 2016-07-20.
 */
public class PdfExtractor {


    public static void main(String[] args) throws IOException, DocumentException {


        // System.out.println("Page Content:\n\n"+page+"\n\n");
        PdfReader reader = new PdfReader("/Users/user/Downloads/PdfReader/src/recourses/maladie.pdf");
        int NombrePage = reader.getNumberOfPages();
        int count = 0;

        for (int i = 1; i <= 1; i++) {
            String page = PdfTextExtractor.getTextFromPage(reader, 36);
            BufferedReader bufReader = new BufferedReader(new StringReader(page));
            String DCI = "";
            String ActionTherapeutique = "";
            String indication = "";
            String contre_indication = "";

            String line = null;
            final float[] curFontSize = new float[1];
            final float[] fontsize = new float[1];

            PdfReader.unethicalreading = true;
            try {
                PdfTextExtractor.getTextFromPage(reader, 36, new TextExtractionStrategy() {
                    public void renderText(TextRenderInfo renderInfo) {
                        Vector curBaseline = renderInfo.getBaseline().getStartPoint();
                        Vector topRight = renderInfo.getAscentLine().getEndPoint();

                        Rectangle rect = new Rectangle(curBaseline.get(0), curBaseline.get(1), topRight.get(0), topRight.get(1));
                        curFontSize[0] = rect.getHeight();

                        fontsize[0] = renderInfo.getAscentLine().getStartPoint().get(1)
                                - renderInfo.getDescentLine().getStartPoint().get(1);
                          System.out.println(curFontSize[0]+" curFontSize  " + fontsize[0]+"  "+renderInfo.getText());
                    }

                    public void renderImage(ImageRenderInfo renderInfo) {
                    }

                    public void endTextBlock() {
                    }

                    public void beginTextBlock() {
                    }

                    public String getResultantText() {
                        return "";
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

            while ((line = bufReader.readLine()) != null) {
            }

            System.out.println(page);
//            if (DCI.length() != 0) {
//                count = count + 1;
//                DCI = DCI.replaceAll("\n", " ");
//                System.out.println("DCI " + count + " :" + "  " + i + " " + DCI);
//            }
        }
    }
}
