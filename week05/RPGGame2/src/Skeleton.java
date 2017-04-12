import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Skeleton extends Monster {


  public Skeleton(BufferedImage image, int posX, int posY, boolean gotKey, int newMaplevel) {
    super(image, posX, posY);
    this.level = 1;
    this.mapLevel += newMaplevel;
    this.maxHP = 2 * mapLevel * 6;
    this.currentHP = 2 * mapLevel * GameLogic.rollTheDice();
    this.defendDP = (mapLevel / 2) * GameLogic.rollTheDice();
    this.strikeSP = mapLevel * GameLogic.rollTheDice();
    this.gotKey = gotKey;
  }

  @Override
  public String toString() {
    return "Skeleton " +
        "(level " + mapLevel +
        ") HP: " + currentHP +
        "/" + maxHP +
        " | DP: " + defendDP +
        " | SP: " + strikeSP;
  }
}
