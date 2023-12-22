package model;

import org.apache.commons.math3.complex.Complex;

public class ComplexCalculator{

    public Complex add(Complex num1, Complex num2) { return num1.add(num2); }

    public Complex subtract(Complex num1, Complex num2) { return num1.subtract(num2); }

    public Complex multiply(Complex num1, Complex num2) { return num1.multiply(num2); }

    public Complex divide(Complex num1, Complex num2) { return num1.divide(num2); }
}
