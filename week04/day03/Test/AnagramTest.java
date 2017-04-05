import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by georgezsiga on 4/5/17.
 */
class AnagramTest {
  Anagram anagram = new Anagram();
  String firstWord = "assd";
  String secondWord = "dfds";

  @BeforeEach
  void setUp() {

  }

  @Test
  void anagram() {
    assertFalse(anagram.anagram(firstWord, secondWord));
  }

}