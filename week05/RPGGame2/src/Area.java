import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Area extends GameObject implements KeyListener {
  int testBoxX;
  int testBoxY;
  int posX;
  int posY;
  int size;
  String filename;

  public Area() {
    testBoxX = 0;
    testBoxY = 0;
    posX = 0;
    posY = 0;
    size = 72;
    filename = "assets/hero-down.png";
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Floor image = new Floor( i * size, j * size);
        image.draw(graphics);
      }
    }

    for (int i = 1; i < 10; i+=2) {
      for (int j = 0; j < 10; j++) {
        if (j % 3 == 0) {

        } else {
          Wall wall = new Wall(i * size, j * size);
          wall.draw(graphics);
        }
      }
    }
    Hero hero = new Hero(filename, testBoxX, testBoxY);
    hero.draw(graphics);

  }

  @Override
  public void keyTyped(KeyEvent keyEvent) {

  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.VK_UP) {
      testBoxY -= size;
      filename = "assets/hero-up.png";
    } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
      testBoxY += size;
      filename = "assets/hero-down.png";
    } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
      testBoxX -= size;
      filename = "assets/hero-left.png";
    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
      testBoxX += size;
      filename = "assets/hero-right.png";
    }
    repaint();
  }


}
