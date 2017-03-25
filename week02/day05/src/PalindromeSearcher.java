import java.util.Scanner;

/**
 * Created by georgezsiga on 3/25/17.
 */
public class PalindromeSearcher {
  public static void main(String[] arg) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please give me some text and I wil find all the Palindromes in it");
    String userInput = scanner.nextLine();
    createPalindrome(userInput);
  }

  private static void createPalindrome(String palindrome) {
    String output = palindrome;
    while (palindrome.length() >= 3)
    for (int i = palindrome.length() - 1; i >= 0; i--) {
      output = output + palindrome.charAt(i);
    }
    System.out.println("Here is it: " + output + " ... pretty cool huh??");
  }
}
//  Create a function named search palindrome following your current language's style guide.
// It should take a string, search for palindromes that at least 3 characters long
// and return a list with the found palindromes.
//
//        Examples
//
//        input	output
//        "dog goat dad duck doodle never"	["og go", "g g", " dad ", "dad", "d d", "dood", "eve"]
//        "apple"	[]
//        ""	[]
