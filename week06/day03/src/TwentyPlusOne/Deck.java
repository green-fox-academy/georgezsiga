package TwentyPlusOne;

import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/19/17.
 */
public class Deck {

  ArrayList<Card> deck;

  public Deck() {
    deck = new ArrayList<>();
    addCards();
  }

  public void addCards() {
    for (CardSuit actualSuit : CardSuit.values()) {
      for (CardRank actualRank : CardRank.values()) {
        Card card = new Card(actualSuit, actualRank);
        deck.add(card);
      }
    }
  }

}
