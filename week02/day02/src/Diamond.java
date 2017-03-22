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
    int half = ((number / 2) + 1);


    for (int i = 0; i <= half; i++) {
      for (int j = (half -1); j >= i; j--) {
        System.out.print(" ");
      }
      for (int k = 1; k <= ((2 * i) - 1); k++) {
        System.out.print("*");
      }
      System.out.println("");
    }
    for (int i = (half -1); i >= 1; i--) {
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