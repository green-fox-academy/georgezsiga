import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by georgezsiga on 4/5/17.
 */
class SumTest {

  ArrayList<Integer> name = new ArrayList<>();

  @Test
  void sumList() {
    Sum sum = new Sum(name);
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
    Sum sum = new Sum(name);
    assertEquals(sum.sumList(), 0);
  }

  @Test
  void sumListOneElement() {
    Sum sum = new Sum(name);
    int a = 2;
    sum.addIntegers(a);
    assertEquals(sum.sumList(), 2);
  }

  @Test
  void sumListNull() {
    Sum sum = new Sum();
    assertNull(sum.getList());
  }
}