import java.util.HashMap;
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
    String userInput = scanner.nextLine();

    String[] splitStr = userInput.split("\\s+");
    String firstWord = splitStr[0];
    String secondWord = splitStr[1];

    System.out.println(firstWord);
    System.out.println(secondWord);

//    int first = Integer.parseInt(firstString);
//    int second = Integer.parseInt(secondString);
//    int result = 0;
//
//
//    String first = userInput.substring(0, userInput.indexOf(" "));
//    String second = userInput.substring(userInput.indexOf(" ") + 1);
//
//    if (first.length() != second.length()) {
//      System.out.println("The words you gave me are not anagrams of each other");
//    } else {
//      HashMap<Character, Integer> hashmap1 = new HashMap<Character, Integer>();
//      for (int i = 0; i < first.length(); i++) {
//        hashmap1 = hashmap1.put(i, first.charAt(i));
//
//      }
//      System.out.println(hashmap1);
//
//      System.out.println(first);
//      System.out.println(second);
//    }
  }
}

//
//  public static String sort (String incomingString) {
//    incomingString = incomingString.toLowerCase();
//    for (int i = 0; i < incomingString.length(); i++) {
//      for (int j = i; j < incomingString.length(); j++) {
//        if (incomingString.charAt(i) > incomingString.charAt(j)) {
//          incomingString = incomingString.substring(0, i)
//                  + incomingString.charAt(j)
//                  + incomingString.substring(i + 1, j)
//                  + incomingString.charAt(i)
//                  + incomingString.substring(j + 1, incomingString.length());
//        }
//      }
//    }
//    return incomingString;
//  }