import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Character extends GameObject{

  public Character(BufferedImage image, int posX, int posY) {
    super(image, posX, posY);
  }

  public int levelGenerator() {
    int randNum = GameLogic.randomNumber();
    if (randNum == 1) {
      return getMapLevel() + 2;
    } else if (randNum == 0 || randNum == 2 || randNum == 3 ) {
      return getMapLevel() + 1;
    } else {
      return getMapLevel();
    }
  }
}
