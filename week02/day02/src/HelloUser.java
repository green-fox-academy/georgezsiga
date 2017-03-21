import java.util.Scanner;

/**
 * Created by georgezsiga on 3/21/17.
 */
public class HelloUser {
  public static void main(String[] args) {
    // Modify this program to greet user instead of the World!
    // The program should ask for the name of the user
    System.out.println("What is your name? ");
    Scanner scanner = new Scanner(System.in);
    String userName = scanner.nextLine();
    System.out.println("Hello, " + userName + "! How is your day so far?");
  }
}
