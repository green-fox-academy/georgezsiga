import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */

// Write a program that reads a number from the standard input, then draws a
// diamond like this:
//
//
//    *
//   ***
//  *****
// *******
//  *****
//   ***
//    *
//
// The diamond should have as many lines as the number was

public class Diamond {
  public static void main(String[] args) {
    System.out.println("Give me a number please");
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    while (number < 3) {
      System.out.println("Please give me a bigger number, this is too small to draw something pretty");
      Scanner scanner2 = new Scanner(System.in);
      number = scanner2.nextInt();
    }
    int half = ((number / 2) + 1);
    int even = (number % 2);
    if (even == 0) {
      for (int i = 0; i < half; i++) {
        for (int j = (half - 1); j >= i; j--) {
          System.out.print(" ");
        }
        for (int k = 1; k <= ((2 * i) - 1); k++) {
          System.out.print("*");
        }
        System.out.println("");
      }
    } else {
      for (int i = 0; i <= half; i++) {
        for (int j = (half - 1); j >= i; j--) {
          System.out.print(" ");
        }
        for (int k = 1; k <= ((2 * i) - 1); k++) {
          System.out.print("*");
        }
        System.out.println("");
      }
    }
    for (int i = (half - 1); i >= 1; i--) {
      for (int j = half; j > i; j--) {
        System.out.print(" ");
      }
      for (int k = 1; k < (i * 2); k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}