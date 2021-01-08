// Margo Raijmakers
// 06-01-2021
// Afvinkopdracht 6

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class overlapGraphs {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException |
                InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        overlapGraphs overlapGraphs = new overlapGraphs();
        String bestand = "dataset.fa";
        int k = 3;
        ArrayList<String> data = overlapGraphs.readFile(bestand);
        HashMap<String, String> seqs = overlapGraphs.convertToHashMap(data);
        try {
            ArrayList<String> adjacencyList = overlapGraphs.checkOverlap(seqs, k);
            for (int i = 0; i < adjacencyList.size(); i++) {
                System.out.println(adjacencyList.get(i) + " " + adjacencyList.get(++i));
            }
        } catch (StringIndexOutOfBoundsException sioobe) {
            System.out.println("Kies een kleiner getal voor k.");
        }
    }


    /**
     * Deze methode leest het bestand in en zet de inhoud van het bestand in een ArrayList.
     *
     * @param bestand de naam van het bestand dat ingelezen moet worden
     * @return de ArrayList met de inhoud van het bestand
     */
    public ArrayList<String> readFile(String bestand) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(bestand));
            String line;
            while ((line = inFile.readLine()) != null) {
                // Voeg iedere regel in het bestand toe aan de ArrayList
                list.add(line);
            }
            inFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "File Error: " + e.toString());
        }
        return list;
    }


    /**
     * Deze methode converteert de ArrayList naar een HashMap.
     *
     * @param data de ArrayList met de inhoud van het bestand
     * @return de sequenties en Rosalind ids in een HashMap
     */
    public HashMap<String, String> convertToHashMap(ArrayList<String> data) {
        HashMap<String, String> seqs = new HashMap<>(5);
        for(String element : data) {
            if (element.contains(">")) {
                // Maak een Hashmap met het Rosalind id als key en de sequentie als value
                seqs.put(element.replace(">", ""), data.get(data.indexOf(element) + 1));
            }
        }
        return seqs;
    }


    /**
     * Deze methode checkt of de sequenties overlap hebben en
     * voegt deze sequenties achter elkaar toe in de adjacency list.
     *
     * @param seqs de HashMap met de Rosalind ids als keys en de sequenties als values
     * @param k hoeveel nucleotiden moeten overlappen
     * @return de adjacency list met de ids van de sequenties die overlappen
     * @throws StringIndexOutOfBoundsException als er een te grote waarde voor k wordt gegeven
     */
    public ArrayList<String> checkOverlap (HashMap<String, String> seqs, int k)
            throws StringIndexOutOfBoundsException{
        ArrayList<String> adjacencyList = new ArrayList<>();
        for(String seq1 : seqs.values()) {
            for (String seq2 : seqs.values()) {
                // Controleer of de sequenties overlappen en voeg deze sequenties toe aan de adjacencyList
                if (seq1.substring(seq2.length() - k).equals(seq2.substring(0, k)) && !seq1.equals(seq2)) {
                    adjacencyList.add(seqsToIDs(seq1, seqs));
                    adjacencyList.add(seqsToIDs(seq2, seqs));
                }
            }
        }
        return adjacencyList;
    }


    /**
     * Deze methode converteert de sequentie naar het Rosalind id.
     *
     * @param seq1 de sequentie waar overlap met een andere sequentie bij gevonden is
     * @param seqs de HashMap met de Rosalind ids als keys en de sequenties als values
     * @return het Rosalind id van de sequentie waar overlap met een andere sequentie bij gevonden is
     */
    public String seqsToIDs (String seq1, HashMap<String, String> seqs) {
        for (Map.Entry<String, String> seq2 : seqs.entrySet()) {
            // Als de sequenties overeenkomen return dan het id.
            if (seq1.equals(seq2.getValue())) {
               return seq2.getKey();
            }
        }
        return null;
    }
}
