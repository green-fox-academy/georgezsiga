/**
 * Created by georgezsiga on 4/10/17.
 */
public class Character {
  int maxHP;
  int currentHP;
  int defendPoint;
  int strikePoint;
  int diceResult;
  boolean isDead;

  public Character() {
    this.isDead = false;
  }

  public boolean isDead() {
    return isDead;
  }

  public int rollTheDice() {
    this.diceResult = (int) Math.random() * 7;
    return diceResult;
  }
}
