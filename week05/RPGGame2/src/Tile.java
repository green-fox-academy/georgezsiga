import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Tile extends GameObject {

  public Tile(BufferedImage image, int posX, int posY) {
    super(image, posX, posY);
    this.isWall = false;
  }

}
