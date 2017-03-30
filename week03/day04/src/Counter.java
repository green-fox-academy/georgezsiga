import java.awt.*;
import java.util.Scanner;

/**
 * Created by georgezsiga on 3/30/17.
 */

// Write a recursive function that takes one parameter: n and counts down from n.
public class Counter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give me a number");
    int number = scanner.nextInt();
    count(number);
  }

  public static int count(int number) {
    if (number == 0) {
      System.out.println(number);
      return 0;
    } else {
      System.out.println(number);
      return number + count(--number);
    }
  }
}

