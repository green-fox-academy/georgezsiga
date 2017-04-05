import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by georgezsiga on 4/5/17.
 */
class FibonacciTest {
  @BeforeEach
  void setUp() {
    Fibonacci fibi = new Fibonacci();
  }
// reference fibonacci number: 0, 1, 1, 2, 3, 5, 8, 13, 21
  @Test
  void fibonacci1() {
    int n = 1;
    assertEquals(Fibonacci.fibonacci(n), 0);
  }
  @Test
  void fibonacci2() {
    int n = 2;
    assertEquals(Fibonacci.fibonacci(n), 1);
  }
  @Test
  void fibonacciLot() {
    int n = 9;
    assertEquals(Fibonacci.fibonacci(n), 21);
  }
}