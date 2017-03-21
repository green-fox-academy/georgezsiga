import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */

public class MileToKmConverter {
  public static void main(String[] args) {
    // Write a program that asks for an integer that is a distance in kilometers,
    // then it converts that value to miles and prints it
    System.out.println("How far do you live from your work/shoon in kms?");
    Scanner scanner = new Scanner(System.in);
    int km = scanner.nextInt();
    double m = 0.621371;
    double miles = km * m;
    System.out.println("You live " + miles + " from your work/home.");
  }
}
