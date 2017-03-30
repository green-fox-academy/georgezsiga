import java.util.Scanner;

/**
 * Created by georgezsiga on 3/30/17.
 */
// Write a recursive function that takes one parameter: n and adds numbers from 1 to n.
public class NumberAdder {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give me a number");
    int number = scanner.nextInt();
    System.out.println(count(number));
  }

  public static int count(int number) {
    if (number == 0) {
      return 0;
    } else {
      return number + count(--number);
    }
  }
}
