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

  public Area() {
    testBoxX = 0;
    testBoxY = 0;
    posX = 0;
    posY = 0;
    setPreferredSize(new Dimension(750, 750));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Tile image = new Tile("assets/floor.png", i*72, j*72);
        image.draw(graphics);
      }

    }
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
      testBoxY -= 100;
    } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
      testBoxY += 100;
    } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
      testBoxX -= 100;
    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
      testBoxX += 100;
    }
    repaint();
  }


}
