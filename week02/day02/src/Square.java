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
    System.out.println("%%%%%");
    for (int i = 0; i < (number - 2); i++) {
      System.out.println("%   %");
    }
    System.out.println("%%%%%");
  }
}
