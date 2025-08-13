package org.example;

public class Calculator {
    public Double sum(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    };

    public Double subtract(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    };

    public Double multiply(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    };

    public Double divide (Double firstNumber, Double secondNumber) {
        return (Double) firstNumber / secondNumber;
    };
}
