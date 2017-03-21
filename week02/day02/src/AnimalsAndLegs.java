import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */

public class AnimalsAndLegs {
  public static void main(String[] args) {
    // Write a program that asks for two integers
    // The first represents the number of chickens the farmer has
    // The seconf represents the number of pigs the farmer has
    // It should print how many legs all the animals have

    System.out.println("How many chickens do you have?");
    Scanner scanner = new Scanner(System.in);
    int chicken = scanner.nextInt();
    System.out.println("How many pigs do you have?");
    Scanner scanner2 = new Scanner(System.in);
    int pigs = scanner2.nextInt();
    int legs = (chicken * 2) + (pigs * 4);
    System.out.println("You have " + legs + " animal legs on your farm.");

  }
}
