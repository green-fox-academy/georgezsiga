/**
 * Created by georgezsiga on 3/22/17.
 */
//  Create the usual class wrapper
//  and main method on your own.

// - Create a function called `factorio`
//   that returns it's input's factorial

public class Factorial {
  public static void main(String[] args) {
    int number = 4;
    System.out.println(factorio(number));
  }

  public static int factorio (int factorTheNumbersTogether) {
    int sum = factorTheNumbersTogether;
    for (int i=1; i<factorTheNumbersTogether; i++) {
      sum = sum * i;
    }
    return sum;
  }
}
