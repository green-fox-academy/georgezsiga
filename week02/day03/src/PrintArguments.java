/**
 * Created by georgezsiga on 3/22/17.
 */

//  Create the usual class wrapper
//  and main method on your own.

// - Create a function called `printer`
//   which prints the input String parameters
//   (can have multiple number of arguments)

public class PrintArguments {
  public static void main(String[] args) {
    String text = "dfjslkdfj";
    String text2 = "dfjslkdfj";
    String text3 = "dfjslkdfj";
    String text4 = "dfjslkdfj";

    printer(text, text2);

  }

  public static void printer (String... printAllTheString) {

    for (String i : printAllTheString) {
      System.out.print(i + " ");
    }
  }
}
