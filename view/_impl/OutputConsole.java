package view._impl;

import view.Output;

public class OutputConsole implements Output {
    
    @Override
    public void showResult(Double result) {
        System.out.println("Результат: " + result);
    }

    @Override
    public void showError(String message) {
        System.out.println("Ошибка: " + message);
    }
    
}
