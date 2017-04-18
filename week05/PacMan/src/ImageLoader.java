import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Created by georgezsiga on 4/14/17.
 */
public class ImageLoader {
  private static ImageLoader instance;

  public BufferedImage BLACK, FLOOR, GREEN, NODOT, PACMAN, RED, WALL, YELLOW;


  private ImageLoader() {
    try {
      WALL = ImageIO.read(new File("assets/wall.png"));
      BLACK = ImageIO.read(new File("assets/black.png"));
      FLOOR = ImageIO.read(new File("assets/dot.png"));
      GREEN = ImageIO.read(new File("assets/green.png"));
      NODOT = ImageIO.read(new File("assets/nodot.png"));
      PACMAN = ImageIO.read(new File("assets/pacman.png"));
      RED = ImageIO.read(new File("assets/red.png"));
      YELLOW = ImageIO.read(new File("assets/yellow.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static ImageLoader getInstance() {
    if (instance == null) {
      instance = new ImageLoader();
    }
    return instance;
  }
}
