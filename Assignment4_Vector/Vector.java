public class Vector {

    int[] comp;       // components of vector
    int dimension;

    // Constructor
    public Vector(int dim) throws InvalidDimensionException {
        if (dim != 2 && dim != 3) {
            throw new InvalidDimensionException("Vector dimension must be 2D or 3D");
        }
        dimension = dim;
        comp = new int[dim];
    }

    // Set values
    public Vector(int x, int y) {
        dimension = 2;
        comp = new int[]{x, y};
    }

    public Vector(int x, int y, int z) {
        dimension = 3;
        comp = new int[]{x, y, z};
    }

    public Vector(int x, int y, int z, int w) throws InvalidDimensionException {
        throw new InvalidDimensionException("Vector dimension must be 2D or 3D");
    }
}

