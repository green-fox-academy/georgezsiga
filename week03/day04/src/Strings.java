import java.util.Scanner;

/**
 * Created by georgezsiga on 3/30/17.
 */
// Given a string, compute recursively (no loops) a new string where all the
// lowercase 'x' chars have been changed to 'y' chars.
public class Strings {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give me the number of bunnies");
    String text = scanner.nextLine();
    System.out.println(modifiedText(text));
  }

  public static int modifiedText(String text) {
    if (text.charAt(0) == 0) {
      return 0;
    }
      return 2 + bunniesEars(--bunnies);
    }
  }
