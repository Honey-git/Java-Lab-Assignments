import java.util.Scanner;   // Importing Scanner class for user input
public class Calculator {   // Main class
public static void main(String[] args) {    // Main method
    Scanner scan = new Scanner(System.in);  // Creating Scanner object for input
    while (true) {
        System.out.println("-------------------------\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Modulus\n0. Exit");
        System.out.println("Enter your choice: ");
        int ch = scan.nextInt();  
        if (ch == 0) {  // Exit condition
                System.out.println("Exiting the calculator. Goodbye!");
                break;
                }
        if (ch < 1 || ch > 5) {
            System.out.println("Error: Invalid choice! Please enter a number between 1 and 5.\n");
            System.out.println("Enter your choice: ");
            continue;
        }
        Arithematic op = new Arithematic(); // Creating an instance of Arithematic class
        double n1, n2;
        System.out.println("Enter first number: "); // Prompting user for first number
        n1 = scan.nextDouble();
        op.n1 = n1;
        System.out.println("Enter second number: ");    // Prompting user for second number
        n2 = scan.nextDouble();
        scan.nextLine();  // Clear the newline after the number
        op.n2 = n2;
        switch(ch) {    // Performing operation based on user choice
            case 1: 
                System.out.println("Sum: " + op.add(op.n1, op.n2) + "\n");
                break;
            case 2:
                System.out.println("Difference: " + op.subtract(op.n1, op.n2) + "\n");
                break;
            case 3:
                System.out.println("Product: " + op.multiply(op.n1, op.n2) + "\n");
                break;
            case 4:
                if (op.n2 == 0) {
                    System.out.println("Error: Division by zero is not allowed!\n");
                } else {
                    System.out.println("Quotient: " + op.divide(op.n1, op.n2) + "\n");
                }
                break;
            case 5:
                if (op.n2 == 0) {
                    System.out.println("Error: Modulus by zero is not allowed!\n");
                } else {
                    System.out.println("Remainder: " + op.modulus(op.n1, op.n2) + "\n");
                }
                break;
            default:
                System.out.println("Invalid choice\n");
        }
    }
    scan.close();   // Closing the scanner
}
}
