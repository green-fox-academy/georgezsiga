/**
 * Created by georgezsiga on 3/23/17.
 */

public class TakesLonger {
  public static void main(String... args){
    String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

    // When saving this quote a disk error has occured. Please fix it.
    // Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
    // Using pieces of the quote variable (instead of just redefining the string)

    String firstPart  = quote.substring(0, 21);
    String secondPart  = quote.substring(21);
    String fixedQuote = firstPart + "always takes longer than " + secondPart;

    System.out.println(fixedQuote);
  }
}
