// Margo Raijmakers
// 25-11-2020
// Afvinkopdracht 3 Stacks

import java.util.Stack;

public class Stacks {

    public static void main(String[] args) {
        Stacks stacks = new Stacks();
        String syntax = "{[(1+2)(3+4)]}";
        if (stacks.checkSyntax(syntax)) {
            System.out.println("Syntax klopt");
        } else {
            System.out.println("Syntax klopt niet");
        }
    }


    /**
     * Deze methode controleert of de syntax klopt.
     *
     * @param syntax de syntax
     * @return true of false, true als de syntax klopt en false als de syntax niet klopt
     */
    public boolean checkSyntax(String syntax) {
        Stack<Character> stack = new Stack<>();
        int count1 = 0; // )
        int count2 = 0; // ]
        int count3 = 0; // }

        // Vul de stack met (, [ en { en tel het aantal ), ] en }
        for (int i = 0; i < syntax.length(); i++) {
            if (syntax.charAt(i) == '(' || syntax.charAt(i) == '[' || syntax.charAt(i) == '{') {
                stack.push(syntax.charAt(i));
            } else if (syntax.charAt(i) == ')') {
                count1++;
            } else if (syntax.charAt(i) == ']') {
                count2++;
            } else if (syntax.charAt(i) == '}') {
                count3++;
            }
        }

        // Haal voor ieder element in de stack 1 van de bij behorende count af en haal dat element uit de stack
        int stackLength = stack.size();
        for (int i = 0; i < stackLength; i++) {
            if (stack.lastElement() == '(') {
                count1--;
                stack.pop();
            } else if (stack.lastElement() == '[') {
                count2--;
                stack.pop();
            } else {
                count3--;
                stack.pop();
            }
        }

        return count1 == 0 && count2 == 0 && count3 == 0;
    }
}
