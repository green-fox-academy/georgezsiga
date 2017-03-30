import java.util.Scanner;

/**
 * Created by georgezsiga on 3/30/17.
 */
// Given a non-negative int n, return the sum of its digits recursively (no loops).
// Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while
// divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
public class SumDigit {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give me a number");
    int number = scanner.nextInt();
    System.out.println(count(number));
  }

  public static int count(int number) {

    if (number == number % 10) {
      return number;
    } else {
      int digit = number%10;
      return digit + count(number / 10);
    }
  }
}
