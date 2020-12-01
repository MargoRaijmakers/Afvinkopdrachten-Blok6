// Margo Raijmakers
// 25-11-2020
// Afvinkopdracht 3 LinkedList

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LinkedLists {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException |
                InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        // Lees het bestand in
        LinkedLists linkedLists = new LinkedLists();
        String bestand = "Homo_sapiens2.gene_info";
        ArrayList<String[]> geneInfoList = linkedLists.readFile(bestand);

        // Haal de header weg
        geneInfoList.remove(0);

        // Vraag de gebruiker of er gebruik gemaakt moet worden van een ArrayList of LinkedList
        Scanner askListType = new Scanner(System.in);
        System.out.println("ArrayList of LinkedList voor de ordenen van de chromosomen?");
        String listType = askListType.nextLine();

        boolean arrayList;
        // Check ingegeven input
        if (listType.toLowerCase().equals("arraylist")) {
            arrayList = true;
        } else if (listType.toLowerCase().equals("linkedlist")) {
            arrayList = false;
        } else {
            System.out.println("Geef ArrayList of LinkedList op");
            // Als er een verkeerde waarde op wordt gegeven, maak dan een ArrayList aan
            arrayList = true;
        }

        //Maak de dataset aan om de BigO te bepalen
        int lenList = 100;
        ArrayList<String[]> geneInfo = new ArrayList<>();
        for (int i = 0; i < lenList; i++) {
            geneInfo.add(geneInfoList.get(i));
        }

        ArrayList<String> chrList = linkedLists.makeChrList(geneInfo);

        long startTime = System.nanoTime();

        // Als er gekozen wordt voor een ArrayList
        if (arrayList){
            ArrayList<ArrayList<String[]>> orderedList = linkedLists.makeOrderedArrayList(chrList, geneInfo);

            long stopTime = System.nanoTime();
            long totalTime = stopTime - startTime;
            System.out.println("Tijd voor het opbouwen van de list: " + totalTime);

            // Print de geordende lijst met genen per chromosoom
            for (ArrayList<String[]> geneList : orderedList) {
                System.out.println("Chromosoom " + geneList.get(0)[6]);
                for (String[] gene : geneList) {
                    System.out.println(Arrays.toString(gene));
                }
            }

            long startTime2 = System.nanoTime();
            System.out.println(Arrays.toString(orderedList.get(16).get(2)));
            long stopTime2 = System.nanoTime();
            long totalTime2 = stopTime2 - startTime2;
            System.out.println("Tijd voor het ophalen van een gen: " + totalTime2);

        // Als er gekozen wordt voor een LinkedList
        } else {
            LinkedList<LinkedList<String[]>> orderedList = linkedLists.makeOrderedLinkedList(chrList, geneInfo);

            long stopTime = System.nanoTime();
            long totalTime = stopTime - startTime;
            System.out.println("Tijd voor het opbouwen van de list: " + totalTime);

            // Print de geordende lijst met genen per chromosoom
            for (LinkedList<String[]> geneList : orderedList) {
                System.out.println("Chromosoom " + geneList.get(0)[6]);
                for (String[] gene : geneList) {
                    System.out.println(Arrays.toString(gene));
                }
            }

            long startTime2 = System.nanoTime();
            System.out.println(Arrays.toString(orderedList.get(16).get(2)));
            long stopTime2 = System.nanoTime();
            long totalTime2 = stopTime2 - startTime2;
            System.out.println("Tijd voor het ophalen van een gen: " + totalTime2);
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
     * Deze methode maakt een Arraylist met de unieke chromosomen aan die in het bestand voorkomen.
     *
     * @param geneInfo de informatie over de genen in het bestand
     * @return de ArrayList met de unieke chromosomen
     */
    public ArrayList<String> makeChrList(ArrayList<String[]> geneInfo) {
        ArrayList<String> chrList = new ArrayList<>();
        for (String[] gene : geneInfo) {
            // Als het gevonden chromosoom nog niet in chrList staat, voeg het dan toe
            if (!chrList.contains(gene[6])) {
                chrList.add(gene[6]);
            }
        }
        return chrList;
    }


    /**
     * Deze methode maakt de ArrayList aan waar alle genen per chromosoom in geordend worden en vult deze.
     *
     * @param chrList de ArrayList met de unieke chromosomen in het bestand
     * @return de ArrayList waar alle genen per chromosoom in geordend worden
     */
    public ArrayList<ArrayList<String[]>> makeOrderedArrayList(ArrayList<String> chrList,
                                                               ArrayList<String[]> geneInfo) {
        // Maak de Arraylist aan
        ArrayList<ArrayList<String[]>> orderedList = new ArrayList<>();
        for (int i = 0; i < chrList.size(); i++) {
            orderedList.add(new ArrayList<>());
        }

        // Vul de Arraylist
        for (String[] gene : geneInfo) {
            for (int i = 0; i < chrList.size(); i++) {
                if (gene[6].equals(chrList.get(i))) {
                    orderedList.get(chrList.indexOf(chrList.get(i))).add(gene);
                }
            }
        }
        return orderedList;
    }


    /**
     * Deze methode maakt de LinkedList aan waar alle genen per chromosoom in geordend worden en vult deze.
     *
     * @param chrList de ArrayList met de unieke chromosomen in het bestand
     * @return de LinkedList waar alle genen per chromosoom in geordend worden
     */
    public LinkedList<LinkedList<String[]>> makeOrderedLinkedList(ArrayList<String> chrList,
                                                                ArrayList<String[]> geneInfo) {
        // Maak de Linkedlist aan
        LinkedList<LinkedList<String[]>> orderedList = new LinkedList<>();
        for (int i = 0; i < chrList.size(); i++) {
            orderedList.add(new LinkedList<>());
        }

        // Vul de LinkedList
        for (String[] gene : geneInfo) {
            for (int i = 0; i < chrList.size(); i++) {
                if (gene[6].equals(chrList.get(i))) {
                    orderedList.get(chrList.indexOf(chrList.get(i))).add(gene);
                }
            }
        }
        return orderedList;
    }

}
