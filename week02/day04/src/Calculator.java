import java.util.Scanner;

/**
 * Created by georgezsiga on 3/23/17.
 */

public class Calculator {
  public static void main(String... args) {

    System.out.println("Please type in the expression:");
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();

    int result = 0;
    if (userInput.contains("+")) {
      int first = Integer.parseInt(userInput.substring(0, userInput.indexOf("+")));
      int second = Integer.parseInt(userInput.substring(userInput.indexOf("+") + 1));
      result = first + second;
      System.out.println("The result of the calculation is: " + result);
    } else {
      if (userInput.contains("-")) {
        int first = Integer.parseInt(userInput.substring(0, userInput.indexOf("-")));
        int second = Integer.parseInt(userInput.substring(userInput.indexOf("-") + 1));
        result = first - second;
        System.out.println("The result of the calculation is: " + result);
      } else {
        if (userInput.contains("/")) {
          double resultDivision = 0;
          double first = Integer.parseInt(userInput.substring(0, userInput.indexOf("/")));
          double second = Integer.parseInt(userInput.substring(userInput.indexOf("/") + 1));
          resultDivision = first / second;
          System.out.println("The result of the calculation is: " + resultDivision);
        } else {
          if (userInput.contains("*")) {
            int first = Integer.parseInt(userInput.substring(0, userInput.indexOf("*")));
            int second = Integer.parseInt(userInput.substring(userInput.indexOf("*") + 1));
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
