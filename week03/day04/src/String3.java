import java.util.Scanner;

/**
 * Created by georgezsiga on 3/30/17.
 */
// Given a string, compute recursively a new string where all the
// adjacent chars are now separated by a "*".
public class String3 {
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
