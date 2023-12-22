package view._impl;

import view.Input;

import java.util.Scanner;

public class InputConsole implements Input {
    
    private Scanner scanner;

    public InputConsole() {
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public double getNumber(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextDouble();
    }
    
    @Override
    public String getOperator(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.next();
    }
}
