import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Boss extends Monster {

  public Boss(BufferedImage image, int posX, int posY) {
    super(image, posX, posY);
    this.level = 1;
    this.maxHP = (2 * level * 6) + 6;
    this.currentHP = (2 * level * GameLogic.rollTheDice()) + GameLogic.rollTheDice();
    this.defendDP = ((level / 2) * GameLogic.rollTheDice()) + (GameLogic.rollTheDice() / 2);
    this.strikeSP = (level * GameLogic.rollTheDice()) + level;
  }

  @Override
  public String toString() {
    return "Boss " +
        "(level " + level +
        ") HP: " + currentHP +
        "/" + maxHP +
        " | DP: " + defendDP +
        " | SP: " + strikeSP;
  }
}
