import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by georgezsiga on 4/5/17.
 */
public class CowsAndBulls {

  private int counter = 0;
  private int cow = 0;
  private int bull = 0;
  private int number;
  int number1, number2, number3, number4;
  private boolean isGameRunning;
  private int[] playerGuess;
  private ArrayList<Integer> guessThis;

  private int randomNumber() {
    this.number = (int) (Math.random() * 10);
    return number;
  }

  public void guessThisNumber() {
    this.guessThis = new ArrayList<>();
    guessThis.add(randomNumber());
    guessThis.add(randomNumber());
    guessThis.add(randomNumber());
    guessThis.add(randomNumber());
  }

  private void count() {
    counter++;
  }

  public boolean isGameRunning() {
    return isGameRunning;
  }

  private int[] guessTheNumbersInput() {
    System.out.println("Can you guess the four digits of the number I thought of?");
    Scanner scanner = new Scanner(System.in);
    this.playerGuess = new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
    this.count();
    return playerGuess;
  }

  public void compareNumbers() {
    bull = 0;
    cow = 0;
    for (int i = 0; i < playerGuess.length; i++) {
//      if (playerGuess[i] == guessThis.get(i)) {
          if (guessThis.contains(playerGuess[i])) {
        bull +=1;
//      for (int j = 0; j < guessThis.size(); j++) {
      if (playerGuess[i] == guessThis.get(i)) {
//          if (guessThis.contains(playerGuess[i])) {
          cow += 1;
          bull -= 1;

        }
      }
    }
  }

  public void guessResult() {
    if (cow < 4) {
      System.out.println(
          "You have " + cow + " cows, and " + bull + " bulls. You guessed " + counter + " times.");
    } else {
      System.out.println("Congratulations! Your guess " + playerGuess[0] + playerGuess[1] + playerGuess[2] + playerGuess[3] + " is the number I thought of. Your guessed it in " + counter + " rounds. You have won the game.");
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    CowsAndBulls newGame = new CowsAndBulls();
    newGame.guessThisNumber();
    System.out.println(newGame.guessThis);
    while (newGame.cow !=4) {
    newGame.guessTheNumbersInput();
    newGame.compareNumbers();
    newGame.guessResult();
    }
  }
}
