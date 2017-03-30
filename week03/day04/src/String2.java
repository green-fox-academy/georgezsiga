import java.util.Scanner;

/**
 * Created by georgezsiga on 3/30/17.
 */
// Given a string, compute recursively a new string where all the 'x' chars have been removed.
public class String2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give me some text");
    String text = scanner.nextLine();
    System.out.println(modifiedText(text));
  }

  public static String modifiedText(String text) {
    if (text.contains("x")) {
      String new1 = text.substring(0, text.indexOf("x"));
      String new2 = text.substring(text.indexOf("x")+1);
      text = new1 + new2;
      return modifiedText(text);
    } else {
      return text;
    }
  }
}
