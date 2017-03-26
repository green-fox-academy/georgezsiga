import java.util.Scanner;

/**
 * Created by georgezsiga on 3/24/17.
 */
//Create a function named is anagram following your current language's style guide.
// It should take two strings and return a boolean value depending on whether its an anagram or not.
public class Anagram {
  public static void main(String[] arg) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Please give me two words");
    String firstWord = scanner.next();
    String secondWord = scanner.next();
    String reverseSecondWord = "";

    for (int i = secondWord.length() - 1; i >= 0; i--) {
      reverseSecondWord = reverseSecondWord + secondWord.charAt(i);
    }
    if (firstWord.equalsIgnoreCase(reverseSecondWord)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }
}
