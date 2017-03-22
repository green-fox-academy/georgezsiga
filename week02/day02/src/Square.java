import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */


// Write a program that reads a number from the standard input, then draws a
// square like this:
//
//
// %%%%%
// %   %
// %   %
// %   %
// %   %
// %%%%%
//
// The square should have as many lines as the number was

public class Square {
  public static void main(String[] args) {
    System.out.println("Give me a number please");
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();

    while (number < 3) {
      System.out.println("Please give me a bigger number, this is too small to draw something pretty");
      Scanner scanner2 = new Scanner(System.in);
      number = scanner2.nextInt();
    }
    for (int i = 1; i <= number; i++) {
      if (i == 1 || i == number) {
        for (int j = 0; j < number; j++) {
          System.out.print("%");
        }
      } else {
        for (int j = 1; j <= number; j++) {
          if (j == 1 || j == number) {
            System.out.print("%");
          } else {
            System.out.print(" ");
          }
        }
      }
      System.out.println();
    }
  }
}

