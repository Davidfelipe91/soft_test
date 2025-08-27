package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*

        Calculator calculator = new Calculator();

        Double sumResult = calculator.sum(1.2, 2.1);

        System.out.println(sumResult);

        */

        Anagram anagram = new Anagram();
        System.out.println(anagram.compareWord("Mani","Iman"));
    }
}