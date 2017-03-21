import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */

// Create a program that asks for two numbers
// If the second number is not bigger than the first one it should print:
// "The second number should be bigger"
//
// If it is bigger it should count from the first number to the second by one
//
// example:
//
// first number: 3, second number: 6, should print:
//
// 3
// 4
// 5

public class SecondNumberBigger {
  public static void main(String[] args) {
    System.out.println("Give me a number please");
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    System.out.println("Give me an other number");
    Scanner scanner2 = new Scanner(System.in);
    int number2 = scanner2.nextInt();

    while (number2 <= number) {
      System.out.println("The second number should be bigger! Give me an other number");
      Scanner scanner3 = new Scanner(System.in);
      number2 = scanner3.nextInt();
    }
    int a = number;
    while (a < number2) {
      System.out.println(a);
      a += 1;
    }

  }
}
