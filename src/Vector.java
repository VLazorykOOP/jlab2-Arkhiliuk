import java.util.InputMismatchException;
import java.util.Scanner;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getMagnitude() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public Vector scalarMultiply(double scalar) {
        return new Vector(x*scalar, y*scalar, z*scalar);
    }

    public Vector add(Vector other) {
        return new Vector(x+other.x, y+other.y, z+other.z);
    }

    public double dotProduct(Vector other) {
        return x*other.x + y*other.y + z*other.z;
    }

    public Vector crossProduct(Vector other) {
        return new Vector(y*other.z - z*other.y, z*other.x - x*other.z, x*other.y - y*other.x);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector) {
            Vector other = (Vector) obj;
            return x == other.x && y == other.y && z == other.z;
        }
        return false;
    }

    public static void main(String[] args) {


        System.out.println("Enter coordinates for Vector 1:");
        double x1=0;
        double y1=0;
        double z1=0;
    do{
    Scanner scanner = new Scanner(System.in);
        try {
            x1 = scanner.nextDouble();
            y1 = scanner.nextDouble();
            z1 = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }while(x1==0 || y1==0 || z1==0);
        Vector vector1 = new Vector(x1, y1, z1);


        System.out.println("Enter coordinates for Vector 2:");
        double x2=0;
        double y2=0;
        double z2=0;
        do{
            Scanner scanner = new Scanner(System.in);
            try {
        x2 = scanner.nextDouble();
        y2 = scanner.nextDouble();
        z2 = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }while(x2==0 || y2==0 || z2==0);
        Vector vector2 = new Vector(x2, y2, z2);

        System.out.println("Vector 1: " + vector1);
        System.out.println("Vector 2: " + vector2);

        System.out.println("Magnitude of Vector 1: " + vector1.getMagnitude());
        System.out.println("Magnitude of Vector 2: " + vector2.getMagnitude());

        System.out.println("Scalar multiplication of Vector 1 by 2: " + vector1.scalarMultiply(2));
        System.out.println("Scalar multiplication of Vector 2 by 3: " + vector2.scalarMultiply(3));

        System.out.println("Addition of Vector 1 and Vector 2: " + vector1.add(vector2));
        System.out.println("Dot product of Vector 1 and Vector 2: " + vector1.dotProduct(vector2));
        System.out.println("Cross product of Vector 1 and Vector 2: " + vector1.crossProduct(vector2));
    }
}