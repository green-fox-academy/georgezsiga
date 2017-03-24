import java.util.Scanner;

/**
 * Created by georgezsiga on 3/24/17.
 */
public class PalindromeBuilder {
  public static void main(String[] arg) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please give me a word and I make a Palindrome out of it");
    String userInput = scanner.nextLine();
    String output = userInput;
    for (int i = userInput.length()-1; i >= 0; i--) {
      output = output + userInput.charAt(i);
    }
    System.out.println("Here is it: " + output + " ... pretty cool huh??");
  }
}
