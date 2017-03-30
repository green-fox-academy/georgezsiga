import java.util.Scanner;

/**
 * Created by georgezsiga on 3/30/17.
 */
// Given base and n that are both 1 or more, compute recursively (no loops)
// the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
public class Power {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give me two numbers - base and n-th power");
    int base = scanner.nextInt();
    int nPower = scanner.nextInt();
    System.out.println(power(base, nPower));
  }

  public static int power(int base, int nPower) {
    if (nPower == 0) {
      return 1;
    } else {
      return base * power(base, nPower-1);
    }
  }
}
