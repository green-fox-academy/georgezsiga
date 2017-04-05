import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by georgezsiga on 4/5/17.
 */
class SharpieTest {

  Sharpie sharpie1 = new Sharpie("blue", 12f);

  @Test
  void use() {
    sharpie1.inkAmount = 10;
    float inkAmount = 9;
    assertEquals(inkAmount, sharpie1.use());
  }

  @Test
  void useEmpty() {
    sharpie1.inkAmount = 0;
    float inkAmount = 0;
    assertEquals(inkAmount, sharpie1.use());
  }
}