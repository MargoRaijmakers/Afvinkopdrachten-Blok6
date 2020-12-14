// Margo Raijmakers
// 09-12-20
// Afvinkopdracht 5 opdracht 2

import java.util.HashMap;
import java.util.Scanner;

public class AminoAcid {

    public static void main(String[] args) {
        HashMap<String, String> oneLetter = new HashMap<>(20);
        oneLetter.put("A", "Ala - Alanine");
        oneLetter.put("R", "Arg - Arginine");
        oneLetter.put("N", "Asn - Asparagine");
        oneLetter.put("D", "Asp - Aspartic acid");
        oneLetter.put("C", "Cys - Cysteine");
        oneLetter.put("Q", "Gln - Glutamine");
        oneLetter.put("E", "Glu - Glutamic acid");
        oneLetter.put("G", "Gly - Glycine");
        oneLetter.put("H", "His - Histidine");
        oneLetter.put("I", "Ile - Isoleucine");
        oneLetter.put("L", "Leu - Leucine");
        oneLetter.put("K", "Lys - Lysine");
        oneLetter.put("M", "Met - Methionine");
        oneLetter.put("F", "Phe - Phenylalanine");
        oneLetter.put("P", "Pro - Proline");
        oneLetter.put("S", "Ser - Serine");
        oneLetter.put("T", "Thr - Threonine");
        oneLetter.put("W", "Trp - Tryptophan");
        oneLetter.put("Y", "Tyr - Tyrosine");
        oneLetter.put("V", "Val - Valine");

        HashMap<String, String> threeLetters = new HashMap<>(20);
        threeLetters.put("Ala", "A - Alanine");
        threeLetters.put("Arg", "R - Arginine");
        threeLetters.put("Asn", "N - Asparagine");
        threeLetters.put("Asp", "D - Aspartic acid");
        threeLetters.put("Cys", "C - Cysteine");
        threeLetters.put("Gln", "Q - Glutamine");
        threeLetters.put("Glu", "E - Glutamic acid");
        threeLetters.put("Gly", "G - Glycine");
        threeLetters.put("His", "H - Histidine");
        threeLetters.put("Ile", "I - Isoleucine");
        threeLetters.put("Leu", "L - Leucine");
        threeLetters.put("Lys", "K - Lysine");
        threeLetters.put("Met", "M - Methionine");
        threeLetters.put("Phe", "F - Phenylalanine");
        threeLetters.put("Pro", "P - Proline");
        threeLetters.put("Ser", "S - Serine");
        threeLetters.put("Thr", "T - Threonine");
        threeLetters.put("Trp", "W - Tryptophan");
        threeLetters.put("Tyr", "Y - Tyrosine");
        threeLetters.put("Val", "V - Valine");

        HashMap<String, String> fullName = new HashMap<>(20);
        fullName.put("Alanine", "A - Ala");
        fullName.put("Arginine", "R - Arg");
        fullName.put("Asparagine", "N - Asn");
        fullName.put("Aspartic acid", "D - Asp");
        fullName.put("Cysteine", "C - Cys");
        fullName.put("Glutamine", "Q - Gln");
        fullName.put("Glutamic acid", "E - Glu");
        fullName.put("Glycine", "G - Gly");
        fullName.put("Histidine", "H - His");
        fullName.put("Isoleucine", "I - Ile");
        fullName.put("Leucine", "L - Leu");
        fullName.put("Lysine", "K - Lys");
        fullName.put("Methionine", "M - Met");
        fullName.put("Phenylalanine", "F - Phe");
        fullName.put("Proline", "P - Pro");
        fullName.put("Serine", "S - Ser");
        fullName.put("Threonine", "T - Thr");
        fullName.put("Tryptophan", "W - Trp");
        fullName.put("Tyrosine", "Y - Tyr");
        fullName.put("Valine", "V - Val");

        // Vraag het aminozuur
        Scanner askListType = new Scanner(System.in);
        System.out.println("Geef een aminozuur: ");
        String aa = askListType.nextLine();

        // Kijk of het opgegeven aminozuur een letter, drie letters of de volledige naam is
        // en print vervolgens de een letter, drie letters en de volledige naam
        if (oneLetter.containsKey(aa)) {
            System.out.println(aa + ": " + oneLetter.get(aa));
        } else if (threeLetters.containsKey(aa)) {
            System.out.println(aa + ": " + threeLetters.get(aa));
        } else if (fullName.containsKey(aa)) {
            System.out.println(aa + ": " + fullName.get(aa));
        } else {
            System.out.println("Niet een bestaand aminozuur");
        }
    }
}
