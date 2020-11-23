// Margo Raijmakers
// 18-11-2020
// Afvinkopdracht 2 opdracht 2

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class GeneObjSort {

    public static void main(String[] args) {
        // Deel a
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException |
                InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        GeneObjSort geneObjSort = new GeneObjSort();
        String bestand = "Homo_sapiens.gene_info";
        ArrayList<String[]> geneInfo = geneObjSort.readFile(bestand);
        ArrayList<Gene> geneArr = new ArrayList<>();
        for(String[] i:geneInfo) {
            // Check of de map_location voldoet aan de 'normale' manier van opschrijven en
            // check of de map_location een getal heeft waar op gesorteerd kan worden
            if (i[7].matches("^[0-9]*[XY]*[pq][0-9]+[.]*[0-9]*$")) {
                // Als het op de p arm ligt
                if (i[7].contains("p")) {
                    geneArr.add(new Gene(i[1], i[2], i[6].split("\\|")[0], 'p',i[7].split("[pq]")[1]));
                // Als het op de q arm ligt
                } else if (i[7].contains("q")){
                    geneArr.add(new Gene(i[1], i[2], i[6].split("\\|")[0], 'q',i[7].split("[pq]")[1]));
                }
            }
        }
        // Sorteer de ArrayList
        Collections.sort(geneArr);
        // Laat de waardes in de gesorteerde ArrayList zien
        for (Gene gene : geneArr){
            System.out.println(gene);
        }

        // Deel b
        int lenList = 1000;
        int pos = 10;
        String geneId = "728855";

        try{
            ArrayList<Gene> bigOtestList = geneObjSort.makeList(geneArr, lenList);

            // a.
            long startTime = System.nanoTime();
            bigOtestList.add(lenList/2, new Gene("1", "AB", "1", 'p', "1.1"));
            long stopTime = System.nanoTime();
            long totalTime = stopTime - startTime;
            System.out.println("Tijd om te inserten in nanoseconde: " + totalTime);
            bigOtestList.remove(lenList/2);

            // b.
            long startTime2 = System.nanoTime();
            System.out.println(bigOtestList.get(pos));
            long stopTime2 = System.nanoTime();
            long totalTime2 = stopTime2 - startTime2;
            System.out.println("Tijd om op te halen op positie in nanoseconde: " + totalTime2);

            // c.
            long startTime3 = System.nanoTime();
            for (Gene gene: bigOtestList) {
                if (gene.getGeneId().equals(geneId)) {
                    System.out.println(gene);
                }
            }
            long stopTime3 = System.nanoTime();
            long totalTime3 = stopTime3 - startTime3;
            System.out.println("Tijd om op te halen op geneId in nanoseconde: " + totalTime3);

            // d.
            Collections.shuffle(bigOtestList);
            long startTime4 = System.nanoTime();
            Collections.sort(bigOtestList);
            long stopTime4 = System.nanoTime();
            long totalTime4 = stopTime4 - startTime4;
            System.out.println("Tijd om de array te sorteren in nanoseconde: " + totalTime4);

        } catch (IndexOutOfBoundsException aioobe){
            JOptionPane.showMessageDialog(null, "Het bestand heeft niet zo veel regels.");
        }
    }


    /**
     * Deze methode leest het bestand in en zet de inhoud van het bestand in een ArrayList.
     *
     * @param bestand de naam van het bestand dat ingelezen moet worden
     * @return de ArrayList met de inhoud van het bestand
     */
    public ArrayList<String[]> readFile(String bestand) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(bestand));
            String line;
            while ((line = inFile.readLine()) != null) {
                // Voeg iedere regel in het bestand toe aan de ArrayList
                list.add(line.split("\t"));
            }
            inFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "File Error: " + e.toString());
        }
        return list;
    }


    /**
     * Deze methode maakt een Arraylist aan om de bigO mee te bepalen.
     *
     * @param geneArr de ArrayList met genen
     * @param lenList de lengte van de ArrayList
     * @return de Arraylist
     */
    public ArrayList<Gene> makeList(ArrayList<Gene> geneArr, int lenList) {
        ArrayList<Gene> bigOtestList = new ArrayList<>();
        for (int i = 0; i < lenList; i++) {
            bigOtestList.add(geneArr.get(i));
        }
        return bigOtestList;
    }
}

