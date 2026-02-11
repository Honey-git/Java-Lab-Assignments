//import java.util.Scanner;

public class Arithematic {  // Arithematic class
    public double n1, n2;
    public double add(double n1, double n2) {   // Addition method
        return n1 + n2;
    }
    public double subtract(double n1, double n2) {  // Subtraction method
        return n1 - n2;
    }
    public double multiply(double n1, double n2) {  // Multiplication method
        return n1 * n2;
    }
    public double divide(double n1, double n2) {    // Division method
        if (n2 == 0) {
            System.out.println("Error: Cannot divide by zero!");    // Handling division by zero
            return 0;
        }
        return (double) n1 / n2;
    }
public double modulus(double a, double b) {  // Modulus method
    if (b == 0) {
        System.out.println("Error: Cannot perform modulus with zero!");  // Handling modulus by zero
        return 0;
    }
    return a % b;
}}

/*public static void main(String[] args) {
    Arithematic op = new Arithematic();
    Scanner sc = new Scanner(System.in); 
    System.out.println("Enter first number: ");
    op.n1 = sc.nextDouble();
    System.out.println("Enter second number: ");
    op.n2 = sc.nextDouble();

    System.out.println("Sum: " + op.add(op.n1, op.n2));
    System.out.println("Difference: " + op.subtract(op.n1, op.n2));
    System.out.println("Product: " + op.multiply(op.n1, op.n2));
    System.out.println("Quotient: " + op.divide(op.n1, op.n2));
    System.out.println("Remainder: " + op.modulus(op.n1, op.n2));
    sc.close();

    }*/