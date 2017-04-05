import java.util.Scanner;

/**
 * Created by georgezsiga on 4/5/17.
 */
public class CowsAndBulls {

  int counter = 0;
  int cow = 0;
  int bull = 0;
  boolean isGameRunning;
  int[] playerGuess;
  int[] guessThis;

  public int randomNumber() {
    int number = (int) (Math.random() * 10);
    return number;
  }

  public int[] guessThisNumber() {
    int[] guessThis = {randomNumber(), randomNumber(), randomNumber(), randomNumber()};
    return guessThis;
  }

  public int count() {
    counter++;
    return counter;
  }

  public boolean isGameRunning() {
    return isGameRunning;
  }

  public int[] guessTheNumbersInput() {
    System.out.println("Can you guess the four digits of the number I thought of?");
    Scanner scanner = new Scanner(System.in);
    int number1 = scanner.nextInt();
    int number2 = scanner.nextInt();
    int number3 = scanner.nextInt();
    int number4 = scanner.nextInt();
    int[] playerGuess = {number1, number2, number3, number4};
    return playerGuess;
  }

  public void compareNumbers() {
    for (int i = 0; i < playerGuess.length; i++) {
      if (playerGuess[i] == guessThis[i]) {
        cow +=1;
      } else {
        for (int j = 0; j < guessThis.length; j++) {
          if (playerGuess[i] == guessThis[j]);
          bull +=1;
        }
      }
    }
  }
}
