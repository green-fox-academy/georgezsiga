import java.util.Scanner;

/**
 * Created by georgezsiga on 3/30/17.
 */
// We have a number of bunnies and each bunny has two big floppy ears.
// We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
public class Bunnies {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give me the number of bunnies");
    int bunnies = scanner.nextInt();
    System.out.println(bunniesEars(bunnies));
  }

  public static int bunniesEars(int bunnies) {
    if (bunnies == 0) {
      return bunnies;
    } else {
      return bunnies + bunniesEars(--bunnies);
    }
  }
}
