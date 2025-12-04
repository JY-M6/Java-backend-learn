import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input c1:");
        double n1real = sc.nextDouble();
        double n1imag = sc.nextDouble();
        System.out.println("input c2:");
        double n2real = sc.nextDouble();
        double n2imag = sc.nextDouble();
        Complex c1 = new Complex(n1real, n1imag);
        Complex c2 = new Complex(n2real, n2imag);
        System.out.println("ComplexNumber a: " + c1.getReal() + " + " + c1.getImag() + "i");
        System.out.println("ComplexNumber b: " + c2.getReal() + " + " + c2.getImag() + "i");
        System.out.println("(a + b) = " + (c1.getReal()+c2.getReal())+ " + "+(c1.getImag()+c2.getImag())+"i");
        System.out.println("(a - b) = "+(c1.getReal()-c2.getReal())+ " + "+(c1.getImag()-c2.getImag())+"i");
        System.out.printf("(a * b) = "+(c1.getReal()*c2.getReal()-(c1.getImag()*c2.getImag()))+" + "+(c1.getReal()*c2.getImag()+c1.getImag()*c2.getReal())+"i");
    }
}
class Complex{
    private double real, imag;

    public Complex() {
        real = 0;
        imag = 0;
    }

    public Complex(double real, double imag) {
        this.imag = imag;
        this.real = real;
    }
    public double getReal() {
        return real;
    }
    public double getImag() {
        return imag;
    }
}