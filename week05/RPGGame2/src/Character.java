import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Character extends GameObject{
  GameLogic gameLogic = new GameLogic();

  public Character(BufferedImage image, int posX, int posY) {
    super(image, posX, posY);
    this.level = level;
    this.maxHP = maxHP;
    this.currentHP = currentHP;
    this.defendDP = defendDP;
    this.strikeSP = strikeSP;
  }
}
