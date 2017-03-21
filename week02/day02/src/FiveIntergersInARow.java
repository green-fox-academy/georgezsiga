import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */
public class FiveIntergersInARow {
  public static void main(String[] args) {
    System.out.println("Give me a number");
    Scanner scanner = new Scanner(System.in);
    int n1 = scanner.nextInt();

    System.out.println("Can I have an other number?");
    Scanner scanner2 = new Scanner(System.in);
    int n2 = scanner2.nextInt();

    System.out.println("And an other one please");
    Scanner scanner3 = new Scanner(System.in);
    int n3 = scanner3.nextInt();

    System.out.println("One more...");
    Scanner scanner4 = new Scanner(System.in);
    int n4 = scanner4.nextInt();

    System.out.println("And one more.. Promise this will be the last one.");
    Scanner scanner5 = new Scanner(System.in);
    int n5 = scanner5.nextInt();

    int sum = (n1 + n2 + n3 + n4);
    double average = (sum / 4);
    System.out.println("The sum of your numbers is: " + sum + ", and the average of them is: " + average);
  }
}
