/**
 * Created by georgezsiga on 4/11/17.
 */
public class GameLogic {

  public  static int rollTheDice() {
    int diceRoll = (int) (Math.random() * 6 + 1);
    return diceRoll;
  }
}
