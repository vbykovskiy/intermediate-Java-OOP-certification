package util;

public class Validator {
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isComplexNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?[+-]\\d+(\\.\\d+)?i");
    }
}
