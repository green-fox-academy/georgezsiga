import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */
public class Bigger {
  // Write a program that asks for two numbers and prints the bigger one
  public static void main(String[] args) {
    System.out.println("Give me a number ... please");
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    System.out.println("Give me an other number... please");
    Scanner scanner2 = new Scanner(System.in);
    int number2 = scanner2.nextInt();

    if (number == number2) {
      System.out.println("These are the same numbers.. you are really funny.. ");
    } else {
      if (number > number2) {
        System.out.println("This one is the bigger: " + number);
      } else
        System.out.println("This one is the bigger: " + number2);
    }
  }
}

