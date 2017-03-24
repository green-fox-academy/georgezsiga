import java.util.Scanner;

/**
 * Created by georgezsiga on 3/24/17.
 */
public class GuessMyNumber {
  public static void main(String[] arg) {
    int myNumber = 54;
    int life = 10;
    System.out.println("Hi, I have a number in mind between 1 and 100. Can you guess what it is?");

    while (life > 0) {
      Scanner scanner = new Scanner(System.in);
      int userInput = scanner.nextInt();

      if (userInput == myNumber) {
        System.out.println("Congratulations! You won the game! You have " + life + " lives left.");
        System.exit(0);
      } else {
        if (userInput > myNumber) {
          life = life - 1;
          if (life == 0) {
            System.out.println("Game over! Sorry, you have no more lives left.");
            System.exit(0);
          } else {
            System.out.println("Too high. You have " + life + " lives left. Try again!");
          }
        } else {
          if (userInput < myNumber) {
            life = life - 1;
            if (life == 0) {
              System.out.println("Game over! Sorry, you have no more lives left.");
              System.exit(0);
            } else {
              System.out.println("Too low. You have " + life + " lives left. Try again!");
            }
          }
        }
      }
    }
  }
}
//  Write a program where the program chooses a number between 1 and 100.
// The player is then asked to enter a guess. If the player guesses wrong,
// then the program gives feedback and ask to enter an other guess until the guess is correct.
//
//        Make the range customizable (ask for it before starting the guessing).
//        You can add lives. (optional)
//        Example
//
//        I've the number between 1-100. You have 5 lives.
//
//        20
//        Too high. You have 4 lives left.
//
//        10
//        Too low. You have 3 lives left.
//
//        15
//        Congratulations. You won!