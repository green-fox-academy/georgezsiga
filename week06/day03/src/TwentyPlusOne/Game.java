package TwentyPlusOne;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by georgezsiga on 4/19/17.
 */
public class Game {

  public int dealersHand() {
    int number = (int) (Math.random() * 7 + 15);
    return number;
  }

  public static void main(String[] args) {
    Game game = new Game();
    Deck deck = new Deck();
    ArrayList<Card> playerCards = new ArrayList<>();
    int dealersScore = game.dealersHand();
    System.out.println("The dealer has " + dealersScore + ". Can you beat it?");
    System.out.println("Your cards are:");
    deck.shuffleDeck();
    playerCards.add(deck.drawFirst());
    playerCards.add(deck.drawFirst());
    int score = playerCards.get(0).value + playerCards.get(1).value;
    System.out.println(playerCards.get(0) + ", " + playerCards.get(1) + " Your score is: " + score);
    System.out.println("Do you want to \"draw\" or \"stop\"?");
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    while (!userInput.contains("stop")) {
      playerCards.add(deck.drawFirst());
      score = 0;
      System.out.println("Reminder: the dealer has " + dealersScore);
      for (Card thiscard : playerCards) {
        System.out.println(thiscard + " ");
        score += thiscard.value;
      }
      System.out.println("Your score is: " + score);
      System.out.println("Do you want to \"draw\" or \"stop\"?");
      scanner = new Scanner(System.in);
      userInput = scanner.nextLine();
    }
    if (score > dealersScore && score < 22) {
      System.out.println("Congratulations, you have won");
      System.exit(0);
    } else {
      System.out.println("Sorry, you lost!");
      System.exit(0);
    }
  }
}
