import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */
public class PartyPeople {

// Write a program that asks for two numbers
// Thw first number represents the number of girls that comes to a party, the
// second the boys
// It should print: The party is exellent!
// If the the number of girls and boys are equal and there are more people coming than 20
//
// It should print: Quite cool party!
// It there are more than 20 people coming but the girl - boy ratio is not 1-1
//
// It should print: Average party...
// If there are less people coming than 20
//
// It should print: Sausage party
// If no girls are coming, regardless the count of the people

  public static void main(String[] args) {
    System.out.println("How many girl there at the party?");
    Scanner scanner = new Scanner(System.in);
    int girls = scanner.nextInt();
    System.out.println("And how many boys?");
    Scanner scanner2 = new Scanner(System.in);
    int boys = scanner2.nextInt();
    int total = (girls + boys);
    if (girls == 0) {
      System.out.println("Sausage party");
    } else {


      if ((girls == boys) && (total > 20)) {
        System.out.println("The party is Excellent!");
      } else {
        if (total > 20) {
          System.out.println("Quite cool party!");
        } else {
          System.out.println("Average party...");
        }
      }
    }
  }
}
