// Margo Raijmakers
// 09-12-20
// Afvinkopdracht 5 opdracht 1

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;

public class GeneFinder extends JFrame implements ActionListener {

    private JTextArea geneArea1, geneArea2, geneArea3;
    private JButton calcButton;
    private JTextArea textArea, textArea2;
    private JLabel label;
    private JComboBox<String> comboBox;
    private final String[] keuzes = {"Overeenkomst 1 & 2", "Overeenkomst 2 & 3", "Overeenkomst 1 & 3"};
    private final Font font = new Font("Arial", Font.PLAIN, 20);


    public static void main(String[] args) {
        GeneFinder frame = new GeneFinder();
        frame.setTitle("GeneFinder Margo Raijmakers");
        frame.setSize(780, 800);
        frame.createGUI();
        frame.setVisible(true);
    }


    /**
     * Deze methode maakt de GUI aan.
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setBackground(Color.BLACK);
        window.setLayout(null);

        // Label
        label = new JLabel();
        label.setText("Voer drie lijsten met genen in:");
        label.setBounds(10, 10, 400, 25);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        window.add(label);

        // Invoervelden
        geneArea1 = new JTextArea();
        geneArea1.setBounds(10, 45, 200, 300);
        geneArea1.setFont(font);
        window.add(geneArea1);

        geneArea2 = new JTextArea();
        geneArea2.setBounds(220, 45, 200, 300);
        geneArea2.setFont(font);
        window.add(geneArea2);

        geneArea3 = new JTextArea();
        geneArea3.setBounds(430, 45, 200, 300);
        geneArea3.setFont(font);
        window.add(geneArea3);

        // Button
        calcButton = new JButton();
        calcButton.addActionListener(this);
        calcButton.setBounds(640, 320, 130, 25);
        calcButton.setText("Calculate");
        calcButton.setFont(font);
        window.add(calcButton);

        // Overeenkomstige genen
        textArea = new JTextArea();
        textArea.setBounds(10, 390, 620, 150);
        textArea.setFont(font);
        window.add(textArea);

        // Drop down
        comboBox = new JComboBox<>(keuzes);
        comboBox.setBounds(10, 550, 250, 25);
        comboBox.setFont(font);
        window.add(comboBox);

        // Overeenkomsige genen tussen twee
        textArea2 = new JTextArea();
        textArea2.setBounds(10, 585, 620, 150);
        textArea2.setFont(font);
        window.add(textArea2);
    }


    /**
     * Deze methode berekent de overeenkomende genen.
     *
     * @param set1 de eerste set met genen
     * @param set2 de tweede set met genen
     * @param set3 de derde set met genen
     */
    public void calculateGenes(HashSet<String> set1, HashSet<String> set2, HashSet<String> set3){
        // Bereken de overeenkomende genen van de twee gekozen sets met genen
        set1.retainAll(set2);
        for (String gene : set1) {
            textArea2.append("\n" + gene);
        }

        // Bereken de overeenkomende genen van de drie sets
        set3.retainAll(set1);
        for (String gene : set3) {
            textArea.append("\n" + gene);
        }
    }


    /**
     * Deze methode kijkt of er een actie uitgevoerd is.
     *
     * @param e als er op de calculate button wordt geklikt
     */
    public void actionPerformed(ActionEvent e) {
        // Maak de HashSets met de genen aan
        HashSet<String> set1 = new HashSet<>(Arrays.asList(geneArea1.getText().split("\n")));
        HashSet<String> set2 = new HashSet<>(Arrays.asList(geneArea2.getText().split("\n")));
        HashSet<String> set3 = new HashSet<>(Arrays.asList(geneArea3.getText().split("\n")));

        // Bereken de overeenkomende genen
        if (comboBox.getSelectedIndex() == 0) {
            textArea.setText("Overeenkomstige genen:");
            textArea2.setText("Overeenkomsten tussen 1 en 2:");
            calculateGenes(set1, set2, set3);
        } else if (comboBox.getSelectedIndex() == 1) {
            textArea.setText("Overeenkomstige genen:");
            textArea2.setText("Overeenkomsten tussen 2 en 3:");
            calculateGenes(set2, set3, set1);
        } else {
            textArea.setText("Overeenkomstige genen:");
            textArea2.setText("Overeenkomsten tussen 1 en 3:");
            calculateGenes(set1, set3, set2);
        }
    }
}