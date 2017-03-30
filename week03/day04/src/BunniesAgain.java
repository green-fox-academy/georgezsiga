import java.util.Scanner;

/**
 * Created by georgezsiga on 3/30/17.
 */
// We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies
// (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say
// have 3 ears, because they each have a raised foot. Recursively return the
// number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
public class BunniesAgain {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give me the number of bunnies");
    int bunnies = scanner.nextInt();
    System.out.println(bunniesEars(bunnies));
  }

  public static int bunniesEars(int bunnies) {
    if (bunnies == 0) {
      return 0;
    } else if (bunnies % 2 == 0) {
      return 3 + bunniesEars(--bunnies);
    } else {
      return 2 + bunniesEars(--bunnies);
    }
  }
}
