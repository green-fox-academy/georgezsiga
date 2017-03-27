import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by georgezsiga on 3/25/17.
 */
public class PalindromeSearcher {
  public static void main(String[] arg) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please give me some text and I wil find all the Palindromes in it");
    String userInput = scanner.nextLine();
    userInput = userInput.toLowerCase();
    String palindromes = "";
// check for letters next to each other..
    for (int ia = 0; ia < userInput.length() + 1; ) {
      for (int ja = ia + 1; ja < userInput.length() + 1; ) {
        if (userInput.charAt(ia) == userInput.charAt(ja)) {
          int start = ia;
          int end = ja;
          while (userInput.charAt(start) == userInput.charAt(end)) {
            if (start != end-1) {
              palindromes = palindromes + userInput.substring(start, end + 1) + ",";
            }
              start = start - 1;
              end = end + 1;
          }
        }
        ia = ia + 1;
        ja = ja + 1;
        if (ja == userInput.length()) {

          // the original check with 2 letters apart...
          for (int i = 0; i < userInput.length() + 1; ) {
            for (int j = i + 2; j < userInput.length() + 1; ) {
              if (userInput.charAt(i) == userInput.charAt(j)) {
                int start = i;
                int end = j;
                while (userInput.charAt(start) == userInput.charAt(end)) {
                  palindromes = palindromes + userInput.substring(start, end + 1) + ",";
                  start = start - 1;
                  end = end + 1;
                }
              }
              i = i + 1;
              j = j + 1;
              if (j == userInput.length()) {
                System.out.println(palindromes);
                System.exit(0);
              }
            }
          }
        }
      }
    }
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