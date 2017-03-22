import java.util.Random;
import java.util.Scanner;

/**
 * Created by georgezsiga on 3/22/17.
 */
// Write a program that stores a number, and the user has to figure it out.
// The user can input guesses, after each guess the program would tell one
// of the following:
//
// The stored number is higher
// The stried number is lower
// You found the number: 8

public class HigherLower {
  public static void main(String[] args) {
    System.out.println("I am thinking of a number... can you guess what it is?");
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    int a = 8;
    while (number != a) {
      if (number < a) {
        System.out.println("The stored number is higher");
        Scanner scanner2 =  new Scanner(System.in);
        number = scanner2.nextInt();
      } else {
        if (number > a) {
          System.out.println("The stored number is lower");
          Scanner scanner3 = new Scanner(System.in);
          number = scanner3.nextInt();
        }
      }
    }
    System.out.println("You found the number:" + a);
  }
}