import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by georgezsiga on 4/5/17.
 */
class FibonacciTest {
Fibonacci fibi = new Fibonacci();
// reference fibonacci number: 0, 1, 1, 2, 3, 5, 8, 13, 21
  @Test
  void fibonacci() {
    int n = 2;
    assertEquals(Fibonacci.fibonacci(n), 1);
  }

}