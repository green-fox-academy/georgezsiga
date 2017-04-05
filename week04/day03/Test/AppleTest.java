import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by georgezsiga on 4/5/17.
 */
class AppleTest {
  String apple = "apple";
  Apple Apple = new Apple(apple);
  @Test
  void getApple() {
    assertEquals(apple, Apple.getApple());
  }

}