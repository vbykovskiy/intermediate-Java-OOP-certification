package controller;

import model.Calculator;
import view.Input;
import view.Output;
import model.Loger;

public class CalculatorController {
    
    private Calculator calculator;
    private Input input;
    private Output output;
    private Loger loger;

    public CalculatorController(Calculator calculator, Input input, Output output, Loger loger) {
        this.calculator = calculator;
        this.input = input;
        this.output = output;
        this.loger = loger;       
    }

    public void run() {
        try {

            double num1 = input.getNumber("Введите первое число");
            double num2 = input.getNumber("Введите второе число");
            String operator = input.getOperator("Введите оператор: +, -, *, /");

            double result = calculator.calculate(num1, num2, operator);

            output.showResult(result);

            loger.log(num1, num2, operator, result);

        } catch (Exception e) {
            output.showError(e.getMessage());
        }
        
    }
}
