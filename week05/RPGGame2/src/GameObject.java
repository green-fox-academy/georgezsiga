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
  int posX, posY, level, maxHP, currentHP, defendDP, strikeSP;
  public static final int SIZE = 72;

  public GameObject() {

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

  public GameObject(String filename, int posX, int posY) {
    this.posX = posX;
    this.posY = posY;
    this.image = getImage(filename);
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
      graphics.drawImage(image, posX, posY, null);
    }
  }

  public int getCurrentHP() {
    return currentHP;
  }

  public void setCurrentHP(int currentHP) {
    this.currentHP = currentHP;
  }
}
