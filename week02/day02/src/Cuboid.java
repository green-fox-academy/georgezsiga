/**
 * Created by georgezsiga on 3/21/17.
 */
public class Cuboid {
    public static void main(String[] args) {
        double side1 = 23.12;
        double side2 = 21.11;
        double side3 = 34.12;
        double surface = 2 * ((side1 * side2) + (side2 * side3) + (side3 * side1));
        double volume = side1 * side2 * side3;
        System.out.println("Surface Area: " + surface);
        System.out.println("Volume: " + volume);
    }
}

// Write a program that stores 3 sides of a cuboid as variables (doubles)
// The program should write the surface area and volume of the cuboid like:
//
// Surface Area: 600
// Volume: 1000