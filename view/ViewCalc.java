package view;

import java.util.Scanner;

public class ViewCalc {
    private Scanner scanner;

    public ViewCalc() {
        scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getUserInput() {
        return scanner.nextLine();
    }
}
