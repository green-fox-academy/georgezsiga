/**
 * Created by georgezsiga on 3/22/17.
 */

// Write a program that prints the numbers from 1 to 100.
// But for multiples of three print “Fizz” instead of the number
// and for the multiples of five print “Buzz”.
// For numbers which are multiples of both three and five print “FizzBuzz”.

public class FizzBuzz {
  public static void main(String[] args) {
    int a = 1;
    while (a <= 100) {
      int b = (a % 3);
      int c = (a % 5);
      if ((b == 0) && (c == 0)) {
        System.out.println("FizzBuzz");
        a += 1;
      } else {
        if (b == 0) {
          System.out.println("Fizz");
          a += 1;
        } else {
          if (c == 0) {
            System.out.println("Buzz");
            a += 1;
          } else {
            System.out.println(a);
            a += 1;
          }
        }
      }
    }
  }
}
