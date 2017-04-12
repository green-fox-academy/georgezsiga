import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Wall extends Tile {

  public Wall(BufferedImage image, int posX, int posY) {
    super(image, posX, posY);
    this.isWall = true;
  }
}
