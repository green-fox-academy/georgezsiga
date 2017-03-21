import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */
public class OddEven {
  public static void main(String[] args) {
    // Write a program that reads a number form the standard input,
    // Than prints "Odd" if the number is odd, or "Even" it it is even.
    System.out.println("Give me a number ... please");
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();

    int result = (number % 2);
    if (result == 0) {
      System.out.println("Even");
    } else {
      System.out.println("Odd");
    }
  }
}
