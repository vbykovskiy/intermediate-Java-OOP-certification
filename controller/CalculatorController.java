package controller;

import model.SimpleCalculator;
import model.ComplexCalculator;
import util.Validator;
import view.ViewCalc;
import util.Logger;

import org.apache.commons.math3.complex.Complex;

public class CalculatorController {
    private ViewCalc view;
    private SimpleCalculator simpleCalculator;
    private ComplexCalculator complexCalculator;

    public CalculatorController() {
        view = new ViewCalc();
        simpleCalculator = new SimpleCalculator();
        complexCalculator = new ComplexCalculator();
    }

    public void start() {
        view.displayMessage("Введите выражение (например, '2 + 3'):");
        view.displayMessage("Или комплексное выражение (например, '12+7i + 5-8i'):");
        String expression = view.getUserInput();

        // Логирование введенного выражения
        Logger.log("Введенное выражение: " + expression);

        String[] tokens = expression.split(" ");

        if (tokens.length == 3) {
            String num1Str = tokens[0];
            String operator = tokens[1];
            String num2Str = tokens[2];

            if (Validator.isNumeric(num1Str) && Validator.isNumeric(num2Str)) {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);

                double result;

                switch (operator) {
                    case "+":
                        result = simpleCalculator.add(num1, num2);
                        view.displayMessage("Результат: " + result);
                        break;
                    case "-":
                        result = simpleCalculator.subtract(num1, num2);
                        view.displayMessage("Результат: " + result);
                        break;
                    case "*":
                        result = simpleCalculator.multiply(num1, num2);
                        view.displayMessage("Результат: " + result);
                        break;
                    case "/":
                        try {
                            result = simpleCalculator.divide(num1, num2);
                            view.displayMessage("Результат: " + result);
                        } catch (IllegalArgumentException e) {
                            view.displayMessage(e.getMessage());
                        }
                        break;
                    default:
                        view.displayMessage("Ошибка: некорректный оператор.");
                        break;
                }
            } else if (Validator.isComplexNumber(num1Str) && Validator.isComplexNumber(num2Str)) {
                Complex num1 = parseComplexNumber(num1Str);
                Complex num2 = parseComplexNumber(num2Str);

                Complex result;

                switch (operator) {
                    case "+":
                        result = complexCalculator.add(num1, num2);
                        view.displayMessage("Результат: " + result);
                        break;
                    case "-":
                        result = complexCalculator.subtract(num1, num2);
                        view.displayMessage("Результат: " + result);
                        break;
                    case "*":
                        result = complexCalculator.multiply(num1, num2);
                        view.displayMessage("Результат: " + result);
                        break;
                    case "/":
                        result = complexCalculator.divide(num1, num2);
                        view.displayMessage("Результат: " + result);
                        break;
                    default:
                        view.displayMessage("Ошибка: некорректный оператор.");
                        break;
                }
            } else {
                view.displayMessage("Ошибка: некорректный ввод чисел.");
            }
        } else {
            view.displayMessage("Ошибка: некорректное выражение.");
        }
    }

    private Complex parseComplexNumber(String numberStr) {
        String[] parts = numberStr.split("[+-]");

        double realPart;
        double imaginaryPart;

        if (numberStr.startsWith("-")) {
            realPart = -Double.parseDouble(parts[1]);
        } else {
            realPart = Double.parseDouble(parts[0]);
        }

        if (numberStr.contains("i")) {
            imaginaryPart = Double.parseDouble(parts[1].substring(0, parts[1].length() - 1));
        } else {
            imaginaryPart = 0.0;
        }

        return new Complex(realPart, imaginaryPart);
    }
}