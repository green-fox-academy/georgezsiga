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
    int k = 1;

    if (userInput.length() == 3 && (userInput.charAt(0) == userInput.charAt(2))) {
      System.out.println(userInput);
    }
    while (k < userInput.length()-1) {
      int i=1;
      int j=1;
      while (userInput.charAt(k - i) == userInput.charAt(k + 1)) {
        for (i = k-i; i >0; i--) {
          for (j = k+j; j < userInput.length(); j++) {
            if (userInput.charAt(i) == userInput.charAt(j)) {
//              String palindrome = userInput.substring(i, j+1);
              System.out.println(userInput.substring(i, j+1));
            }
          }j=j+1;
        }
      }  k=k+1;
    } /*if (userInput.charAt(userInput.length()-2) == userInput.charAt(userInput.length())) {
      System.out.println(userInput.substring(userInput.length()-2, 3));
    }*/
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
