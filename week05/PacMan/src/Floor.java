import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/17/17.
 */
public class Floor extends Tile {

  public Floor(BufferedImage image, int posX, int posY) {
    super(image, posX, posY);
    this.isWall = false;
    this.isDot = true;
  }
}
