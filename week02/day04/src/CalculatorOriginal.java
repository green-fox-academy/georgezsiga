import java.util.Scanner;

/**
 * Created by georgezsiga on 3/23/17.
 */
public class CalculatorOriginal {
  public static void main(String... args) {

    System.out.println("Please type in the expression in this format (* 5 6):");
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();

    String[] splitStr = userInput.split("\\s+");
    String string = splitStr[0];
    String firstString = splitStr[1];
    String secondString = splitStr[2];
    int first = Integer.parseInt(firstString);
    int second = Integer.parseInt(secondString);
    int result = 0;

    if (string.equals("+")) {
      result = first + second;
      System.out.println("The result of the calculation is: " + result);
    } else {
      if (string.equals("-")) {
        result = first - second;
        System.out.println("The result of the calculation is: " + result);
      } else {
        if (string.equals("/")) {
          double result2 = 0;
          result2 = first / second;
          System.out.println("The result of the calculation is: " + result2);
        } else {
          if (string.equals("*")) {
            result = first * second;
            System.out.println("The result of the calculation is: " + result);
          }
        }
      }
    }
  }
}
// Create a simple calculator application which reads the parameters from the prompt
// and prints the result to the prompt.
// It should support the following operations:
// +, -, *, /, % and it should support two operands.
// The format of the expressions must be: {operation} {operand} {operand}.
// Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

// You can use the Scanner class
// It should work like this:

// Start the program
// It prints: "Please type in the expression:"
// Waits for the user input
// Print the result to the prompt
// Exit