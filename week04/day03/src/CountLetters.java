import java.util.HashMap;
import java.util.Map;

/**
 * Created by georgezsiga on 4/5/17.
 */
public class CountLetters {

  public Map countLetters(String inputString) {
    inputString = inputString.toLowerCase();
    HashMap<Character, Integer> dictionaryMap = new HashMap<>();
    for (int i = 0; i < inputString.length(); ) {
      int counter = 0;
      char currentCharacter = inputString.charAt(i);
      for (int j = 0; j < inputString.length(); j++) {
        if (inputString.charAt(j) == currentCharacter) {
          counter++;
        }
      }
      if (!dictionaryMap.containsKey(inputString.charAt(i))) {
        dictionaryMap.put(inputString.charAt(i), counter++);
      }
    }
    return dictionaryMap;
  }
}
