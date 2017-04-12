import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Skeleton extends Monster {

  public Skeleton(BufferedImage image, int posX, int posY) {
    super(image, posX, posY);
    this.level = 1;
    this.maxHP = 2 * level * 6;
    this.currentHP = 2 * level * GameLogic.rollTheDice();
    this.defendDP = (level / 2) * GameLogic.rollTheDice();
    this.strikeSP = level * GameLogic.rollTheDice();
  }

  @Override
  public String toString() {
    return "Skeleton " +
        "(level " + level +
        ") HP: " + currentHP +
        "/" + maxHP +
        " | DP: " + defendDP +
        " | SP: " + strikeSP;
  }
}
