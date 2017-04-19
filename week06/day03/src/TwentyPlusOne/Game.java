package TwentyPlusOne;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by georgezsiga on 4/19/17.
 */
public class Game {

  public int dealersHand() {
    int number = (int) (Math.random()*7 + 15);
    return number;
  }

  public static void main(String[] args) {
    Game game = new Game();
    Deck deck = new Deck();
    ArrayList<Card> playerCards = new ArrayList<>();

    System.out.println("The dealer has " + game.dealersHand() + ". Can you beat it?");
    System.out.println("Your cards are:");
    deck.shuffleDeck();
    playerCards.add(deck.drawFirst());
    playerCards.add(deck.drawFirst());
    System.out.println(playerCards.get(0) + ", " + playerCards.get(1));
    System.out.println("Do you want to \"draw\" or \"stop\"?");
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    if (userInput.contains("stop")) {

    }

  }

}
