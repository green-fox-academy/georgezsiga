import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */

// Write a program that reads a number from the standard input, then draws a
// pyramid like this:
//
//
//    *
//   ***
//  *****
// *******
//
// The pyramid should have as many lines as the number was

public class TriangleStraight {
  public static void main(String[] args) {
    System.out.println("Give me a number please");
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();

    for (int i = 0; i <= number; i++) {
      for (int j = (number - 1); j >= i; j--) {
        System.out.print(" ");
      }

      for (int k = 1; k <= ((2 * i) - 1); k++) {
        System.out.print("*");
      }
      System.out.println("");
    }
  }
}

