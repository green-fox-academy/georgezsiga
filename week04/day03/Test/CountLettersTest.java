import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

/**
 * Created by georgezsiga on 4/5/17.
 */
class CountLettersTest {
  CountLetters count = new CountLetters();

  @Test
  void countLetters() {
    HashMap<Character, Integer> counting = new HashMap<>();
    String testWord = "asdd";
    counting.put('a', 1);
    counting.put('s', 1);
    counting.put('d', 2);
    assertEquals(counting, count.countLetters(testWord));
  }
}
