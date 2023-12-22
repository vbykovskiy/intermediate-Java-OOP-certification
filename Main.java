import controller.CalculatorController;
import view.Input;
import view.Output;
import view._impl.InputConsole;
import view._impl.OutputConsole;
import model.Calculator;
import model._impl.BasicCalculator;
import model._impl.LogToFile;
import model.Loger;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();
        Input input = new InputConsole();
        Output output = new OutputConsole();
        Loger loger = new LogToFile();
        CalculatorController calculatorController = new CalculatorController(calculator, input, output, loger);
        calculatorController.run();
    }
}
