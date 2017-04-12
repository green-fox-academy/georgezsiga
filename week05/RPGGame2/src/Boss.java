import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Boss extends Monster {

  public Boss(BufferedImage image, int posX, int posY, int newMaplevel) {
    super(image, posX, posY);
    this.mapLevel += newMaplevel;
    this.level = levelGenerator();
    this.maxHP = (2 * mapLevel * 6) + 6;
    this.currentHP = (2 * mapLevel * GameLogic.rollTheDice()) + GameLogic.rollTheDice();
    this.defendDP = ((mapLevel / 2) * GameLogic.rollTheDice()) + (GameLogic.rollTheDice() / 2);
    this.strikeSP = (mapLevel * GameLogic.rollTheDice()) + mapLevel;
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
