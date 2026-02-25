public class VectorOperations {

    // Addition using for loop
    public static Vector add(Vector v1, Vector v2) throws InvalidDimensionException {

        if (v1.dimension != v2.dimension) {
            throw new InvalidDimensionException("Dimensions must be same!");
        }

        Vector result = new Vector(v1.dimension);

        for (int i = 0; i < v1.dimension; i++) {
            result.comp[i] = v1.comp[i] + v2.comp[i];
        }

        return result;
    }

    // Subtraction using for loop
    public static Vector subtract(Vector v1, Vector v2) throws InvalidDimensionException {

        if (v1.dimension != v2.dimension) {
            throw new InvalidDimensionException("Dimensions must be same!");
        }

        Vector result = new Vector(v1.dimension);

        for (int i = 0; i < v1.dimension; i++) {
            result.comp[i] = v1.comp[i] - v2.comp[i];
        }

        return result;
    }

    // Dot Product using for loop
    public static int dotProduct(Vector v1, Vector v2) throws InvalidDimensionException {

        if (v1.dimension != v2.dimension) {
            throw new InvalidDimensionException("Dimensions must be same!");
        }

        int dot = 0;

        for (int i = 0; i < v1.dimension; i++) {
            dot = dot + (v1.comp[i] * v2.comp[i]);
        }

        return dot;
    }
}
