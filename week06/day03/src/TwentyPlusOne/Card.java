package TwentyPlusOne;

/**
 * Created by georgezsiga on 4/19/17.
 */
public class Card {

  private final CardSuit cardSuit;
  private final CardRank cardRank;
  private final CardColor cardColor;

  public Card(CardSuit cardSuit, CardRank cardRank) {
    this.cardSuit = cardSuit;
    this.cardRank = cardRank;
    this.cardColor = whatColor(cardSuit);
  }

  public CardColor whatColor(CardSuit cardSuit) {
    if (cardSuit == CardSuit.DIAMONDS || cardSuit == CardSuit.HEARTS) {
      return CardColor.RED;
    } else {
      return CardColor.BLACK;
    }
  }

}
