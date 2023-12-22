package model._impl;

import model.Loger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogToFile implements Loger {
    
    @Override
    public void log(double num1, double num2, String operator, double result) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("CalculatorLog.txt", true))) {
            writer.println("Операция: " + num1 + " " + operator + " " + num2 + " = " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
