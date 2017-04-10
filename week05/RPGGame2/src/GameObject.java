import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JComponent;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class GameObject extends JComponent {
  BufferedImage image;
  int posX, posY;

  public GameObject() {

  }

  public int getPosX() {
    return posX;
  }

  public int getPosY() {
    return posY;
  }

  public GameObject(String filename, int posX, int posY) {
    this.posX = posX;
    this.posY = posY;
    try {
      image = ImageIO.read(new File(filename));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void draw(Graphics graphics) {
    if (image != null) {
      graphics.drawImage(image, posX, posY, null);
    }
  }
}
