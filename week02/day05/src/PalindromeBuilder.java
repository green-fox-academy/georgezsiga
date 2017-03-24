import java.util.Scanner;

/**
 * Created by georgezsiga on 3/24/17.
 */
public class PalindromeBuilder {
  public static void main(String[] arg) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please give me a word and I make a Palindrome out of it");
    String userInput = scanner.nextLine();
    createPalindrome(userInput);
  }

  private static void createPalindrome(String palindrome) {
    String output = palindrome;
    for (int i = palindrome.length() - 1; i >= 0; i--) {
      output = output + palindrome.charAt(i);
    }
    System.out.println("Here is it: " + output + " ... pretty cool huh??");
  }
}

//  Create a function named create palindrome following your current language's style guide.
//        It should take a string, create a palindrome from it and then return it.