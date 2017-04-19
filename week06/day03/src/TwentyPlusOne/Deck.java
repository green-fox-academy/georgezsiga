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

  public void shuffleDeck() {
    ArrayList<Card> tempDeck = new ArrayList<>();
    while (deck.size() > 0) {
      Card card = deck.get(randomGetACard(deck.size()));
      tempDeck.add(card);
      deck.remove(card);
    }
    deck = tempDeck;
  }

  public int randomGetACard(int deckSize) {
    int getThisCard = (int) (Math.random() * deckSize);
    return getThisCard;
  }

  public Card drawFirst() {
    Card card = deck.get(0);
    deck.remove(card);
    return card;
  }

  public Card drawLast() {
    Card card = deck.get(deck.size());
    deck.remove(card);
    return card;
  }

  public Card drawRandom() {
    Card card = deck.get(randomGetACard(deck.size()));
    deck.remove(card);
    return card;
  }

}
