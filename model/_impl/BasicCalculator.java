package model._impl;

import model.Calculator;

public class BasicCalculator implements Calculator {
    
    @Override
    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Деление на ноль недопустимо");                    
                }
            default:
                throw new IllegalArgumentException("Неверный оператор: " + operator);
        }
    }
}
