import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * Created by georgezsiga on 4/14/17.
 */
public class GameObject extends JComponent {
  public static final int SIZE = 20;
  int posX,posY;
  BufferedImage image;
  boolean isWall, isDot;

  public GameObject(BufferedImage image, int posX, int posY) {
    this.posX = posX;
    this.posY = posY;
    setImage(image);
  }

  protected void setImage(BufferedImage image) {
    this.image = image;
  }

  public BufferedImage getImage(String filename) {
    try {
      image = ImageIO.read(new File(filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return image;
  }

  public void draw(Graphics graphics) {
    if (image != null) {
      graphics.drawImage(image, posX * SIZE, posY * SIZE, null);
    }
  }

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public boolean isDot() {
    return isDot;
  }

  public void setDot(boolean dot) {
    isDot = dot;
  }
}
