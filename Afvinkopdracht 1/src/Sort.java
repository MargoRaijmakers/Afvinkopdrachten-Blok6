// Margo Raijmakers
// 15-11-2020
// Afvinkopdracht 1 blok 6 opdracht 2 en 3

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int min = 1;
        int max = 1000000000;
        int hoeveelheidGetallen = 1000000;
        Sort sort = new Sort();
        ArrayList<Integer> lijst = sort.generateLijst(min, max, hoeveelheidGetallen);
        // converteer ArrayList<Integer> naar int[]
        int[] array = lijst.stream().mapToInt(i -> i).toArray();
        // bereken de tijd die het kost om de ArrayList lijst te sorteren
        long startTime = System.nanoTime();
        sort.QuickSort(array);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(Arrays.toString(array));
        System.out.println("Tijd: " + totalTime + " nanoseconde");
    }


    /**
     * Deze methode genereert de lijst met 1000000 getallen tussen 1 en 1000000000.
     *
     * @param min het minimale getal in de lijst (1)
     * @param max het maximale getal in de lijst (1000000000)
     * @param hoeveelheidGetallen de hoeveelheid getallen in de lijst (1000000)
     * @return de lijst met 1000000 getallen tussen 1 en 1000000000
     */
    public ArrayList<Integer> generateLijst(int min, int max, int hoeveelheidGetallen) {
        int range = max - min + 1;
        ArrayList<Integer> lijst = new ArrayList();
        // Voeg 1000000 random getallen toe aan de ArrayList lijst
        for(int i = 0; i < hoeveelheidGetallen; i++) {
            lijst.add((int) (Math.random() * range) + min);
        }
        return lijst;
    }


    /**
     * Deze methode voert de QuickSort uit.
     * Gekopieerd van wikipedia: https://nl.wikipedia.org/wiki/Quicksort
     *
     * @param Lijst de lijst met 1000000 getallen tussen 1 en 1000000000
     */
    public void QuickSort(int[] Lijst)
    {
        Sort(Lijst, 0, Lijst.length - 1);
    }


    /**
     * Deze methode sorteert de lijst met 1000000 getallen tussen 1 en 1000000000.
     * Gekopieerd van wikipedia: https://nl.wikipedia.org/wiki/Quicksort
     *
     * @param Lijst de lijst met 1000000 getallen tussen 1 en 1000000000
     * @param Links de index voor het meest linkse getal in de lijst
     * @param Rechts de index voor het meest rechtse getal in de lijst
     */
    private void Sort(int[] Lijst, int Links, int Rechts)
    {
        int L = Links;
        int R = Rechts;
        int middelsteElement = Lijst[(Links + Rechts) / 2];

        do
        {
            while(Lijst[L] < middelsteElement)
            {
                L++;
            }
            while(middelsteElement < Lijst[R])
            {
                R--;
            }

            if(L <= R)
            {
                int linksteElement = Lijst[L];
                Lijst[L] = Lijst[R];
                Lijst[R] = linksteElement ;
                L++;
                R--;
            }
        } while(L < R);

        if(Links < R)
        {
            Sort(Lijst, Links, R);
        }
        if(L < Rechts)
        {
            Sort(Lijst, L, Rechts);
        }
    }
}
