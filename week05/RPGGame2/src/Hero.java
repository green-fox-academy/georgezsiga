import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Hero extends Character {

  public Hero(BufferedImage image, int posX, int posY) {
    super(image, posX, posY);
    this.level = 1;
    this.maxHP = 20 + (3 * GameLogic.rollTheDice());
    this.currentHP = maxHP;
    this.defendDP = 2 * GameLogic.rollTheDice();
    this.strikeSP = 5 + GameLogic.rollTheDice();
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
