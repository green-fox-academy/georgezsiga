
/**
 * Created by georgezsiga on 4/10/17.
 */
public class Hero extends Character {

  public Hero(String filename, int posX, int posY) {
    super(filename, posX, posY);
    this.level = 1;
    this.maxHP = 38;
    this.currentHP = 20 + (2 * gameLogic.rollTheDice());
    this.defendDP = 2 * gameLogic.rollTheDice();
    this.strikeSP = 5 + gameLogic.rollTheDice();
  }

  @Override
  public String toString() {
    return "Hero " +
        "(level " + level +
        ") HP: " + currentHP +
        "/" + maxHP +
        " | DP: " + defendDP +
        " | SP: " + strikeSP;
  }
}
