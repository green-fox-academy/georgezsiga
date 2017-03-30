import java.util.Scanner;

/**
 * Created by georgezsiga on 3/30/17.
 */
// The fibonacci sequence is a famous bit of mathematics, and it happens to
// have a recursive definition. The first two values in the sequence are
// 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the
// previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21
// and so on. Define a recursive fibonacci(n) method that returns the nth
// fibonacci number, with n=0 representing the start of the sequence.
public class Fibonacci {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give me some text");
    String text = scanner.nextLine();
    int loops = text.length();
    int i = 0;
    System.out.println(modifiedText(text, loops, i));
  }

  public static String modifiedText(String text, int loops, int i) {
    if (loops == 1) {
      return text;
    } else {
      String new1 = text.substring(0, i+1);
      String new2 = text.substring(i+1);
      text = new1 + "*" + new2;
      i +=2;
      loops -= 1;
      return modifiedText(text, loops, i);
    }
  }
}
