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
    for (int i = 0; i + 2 < userInput.length(); i++) {
      for (int j = i + 2; j < userInput.length(); j++) {
        if (userInput.charAt(i) == userInput.charAt(j)) {
          palindromes = palindromes + userInput.substring(i, j + 1) + " ";
          i = i + 1;
        }
      }
      System.out.println(palindromes);
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