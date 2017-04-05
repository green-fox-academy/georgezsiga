import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by georgezsiga on 4/5/17.
 */
class SumTest {
  ArrayList<Integer> list;
  Sum sum = new Sum();

  @BeforeEach
  void setUp() {
    sum = new Sum();
  }

  @Test
  void sumList() {
    int a = 2;
    int b = 3;
    int c = 4;
    sum.addIntegers(a);
    sum.addIntegers(b);
    sum.addIntegers(c);
    assertEquals(sum.sumList(), 9);
  }

  @Test
  void sumListEmpty() {
    assertEquals(sum.sumList(), 0);
  }

  @Test
  void sumListOneElement() {
    int a = 2;
    sum.addIntegers(a);
    assertEquals(sum.sumList(), 2);
  }
}