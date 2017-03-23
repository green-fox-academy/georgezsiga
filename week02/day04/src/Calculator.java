import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by georgezsiga on 3/23/17.
 */

public class Calculator {
  public static void main(String... args) {
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

    ArrayList<String> MATH = new ArrayList<>(Arrays.asList("/","*","+","-"));

    System.out.println("Please type in the expression:");
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    int first = Integer.parseInt(userInput.substring(0, 1));
    int whatToDo = MATH.indexOf(userInput.substring(1));
    int second = Integer.parseInt(userInput.substring(2));
    int result = 0;

    if (MATH.contains("/")) {
      result = first / second;
    }


    System.out.println("The result of the calculation is: " + second);
  }
}