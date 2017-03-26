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
    System.out.println(firstWord);
    System.out.println(secondWord);

    String reverseSecondWord = "";
    for (int i=secondWord.length()-1; i>=0; i--) {
      reverseSecondWord = reverseSecondWord + secondWord.charAt(i);

    }
    System.out.println(reverseSecondWord);

    if (firstWord.length() != secondWord.length()) {
      System.out.println("false");
      System.exit(0);
    } else {
      int i = 0;
      int j = firstWord.length();
      while (i == j)
        for (i = 0; i < secondWord.length(); i++) {
          for (j = firstWord.length() - 1; j >= 0; j--) {

            if (i == j) {
              System.out.println("true");
            } else {
              System.out.println("false");
            }
          }
        }
    }
  }
}
