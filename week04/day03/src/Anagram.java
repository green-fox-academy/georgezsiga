/**
 * Created by georgezsiga on 4/5/17.
 */
public class Anagram {

  public boolean anagram(String firstWord, String secondWord) {
    String reverseSecondWord = "";
    for (int i = secondWord.length() - 1; i >= 0; i--) {
      reverseSecondWord = reverseSecondWord + secondWord.charAt(i);
    }
    if (firstWord.equalsIgnoreCase(reverseSecondWord)) {
      return true;
    } else {
      return false;
    }
  }
}
