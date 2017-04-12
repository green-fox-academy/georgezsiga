/**
 * Created by georgezsiga on 4/11/17.
 */
public class GameLogic {

  public  static int rollTheDice() {
    int diceRoll = (int) (Math.random() * 6 + 1);
    return diceRoll;
  }

  public static int randomNumber() {
    int rNumber = (int) (Math.random() * 10);
    return rNumber;
  }

  public static int randomMonsters() {
    int rNumber = (int) (Math.random() * 3 + 1);
    return rNumber;
  }

  public static int randomMove() {
    int rNumber = (int) (Math.random() * 4);
    return rNumber;
  }
}
