// Margo Raijmakers
// 05-12-20
// Afvinkopdracht 4 opdracht 2
public class HuffmanAlgoritme {

    public static void main(String[] args) {
        String seq = "tatgccaatgcatttttgcccgcatgaagcatgtagcgcgcatgcctacctgcacgc";
        int counta = 0;
        int countt = 0;
        int countc = 0;
        int countg = 0;
        StringBuilder encodedDNA = new StringBuilder();
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == 'a') {
                counta++;
                encodedDNA.append("111");
            } else if (seq.charAt(i) == 't') {
                countt++;
                encodedDNA.append("10");
            } else if (seq.charAt(i) == 'c') {
                countc++;
                encodedDNA.append("0");
            } else {
                countg++;
                encodedDNA.append("110");
            }
        }
        System.out.println("a: " + counta);
        System.out.println("t: " + countt);
        System.out.println("c: " + countc);
        System.out.println("g: " + countg);
        System.out.println(encodedDNA);
    }
}
