import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Created by georgezsiga on 4/12/17.
 */
public class ImageLoader {

  private static ImageLoader instance;

  public BufferedImage FLOOR, WALL, HERO_UP, HERO_DOWN, HERO_LEFT, HERO_RIGHT, BOSS, SKELETON, AZE, KOND, SZILVI, TOJAS, GYURI;


  private ImageLoader() {
    try {
      FLOOR = ImageIO.read(new File("assets/floor.png"));
      WALL = ImageIO.read(new File("assets/wall.png"));
      HERO_UP = ImageIO.read(new File("assets/hero-up.png"));
      HERO_DOWN = ImageIO.read(new File("assets/hero-down.png"));
      HERO_LEFT = ImageIO.read(new File("assets/hero-left.png"));
      HERO_RIGHT = ImageIO.read(new File("assets/hero-right.png"));
      BOSS = ImageIO.read(new File("assets/boss.png"));
      SKELETON = ImageIO.read(new File("assets/skeleton.png"));
      AZE = ImageIO.read(new File("assets/aze.jpg"));
      KOND = ImageIO.read(new File("assets/kond.jpg"));
      SZILVI = ImageIO.read(new File("assets/szilvi.jpg"));
      TOJAS = ImageIO.read(new File("assets/tojas.jpg"));
      GYURI = ImageIO.read(new File("assets/gyuri.jpg"));

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
