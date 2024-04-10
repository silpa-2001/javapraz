import java.util.Scanner;
class Complex {
    private double real;
    private double imaginary;
    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public Complex sum(Complex other) {
        double realSum = this.real + other.real;
        double imaginarySum = this.imaginary + other.imaginary;
        return new Complex(realSum, imaginarySum);
    }
    public void display() {
        System.out.println("Complex number: " + this.real + " + " + this.imaginary + "i");
    }
    public void setReal(double real) {
        this.real = real;
    }
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Complex complex1 = new Complex();
        Complex complex2 = new Complex();
        Complex complex3;
        System.out.println("Enter real and imaginary parts for first complex number:");
        double real1 = scanner.nextDouble();
        double imaginary1 = scanner.nextDouble();
        System.out.println("Enter real and imaginary parts for second complex number:");
        double real2 = scanner.nextDouble();
        double imaginary2 = scanner.nextDouble();
        complex1.setReal(real1);
        complex1.setImaginary(imaginary1);
        complex2.setReal(real2);
        complex2.setImaginary(imaginary2);
complex3 = complex1.sum(complex2);        
        System.out.println("First complex number:");
        complex1.display();
        System.out.println("Second complex number:");
        complex2.display();
        System.out.println("Sum of the two complex numbers:");
        complex3.display();
    }
}
