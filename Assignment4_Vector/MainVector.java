import java.util.Arrays;

public class MainVector {
    public static void main(String[] args) {

        try {
            Vector v1 = new Vector(2, 3, 4);
            Vector v2 = new Vector(4, 5, 6, 7);

            Vector sum = VectorOperations.add(v1, v2);
            Vector diff = VectorOperations.subtract(v1, v2);
            int dot = VectorOperations.dotProduct(v1, v2);

            System.out.println("\nAddition Result: " + Arrays.toString(sum.comp));
            System.out.println("Subtraction Result: " + Arrays.toString(diff.comp));
            System.out.println("Dot Product Result: " + dot);

        } catch (InvalidDimensionException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}

