

/**
 * Created by georgezsiga on 3/22/17.
 */
//  Create the usual class wrapper
//  and main method on your own.

// - Write a function called `sum` that sum all the numbers
//   until the given parameter
public class Summing {
  public static void main(String[] args) {
    int number = 3;
    System.out.println(sum(number));
  }

  public static int sum (int addTheNumbersTogether) {
    int sum = addTheNumbersTogether;
    for (int i=0; i<addTheNumbersTogether; i++) {
      sum = sum + i;
    }
    return sum;
  }
}