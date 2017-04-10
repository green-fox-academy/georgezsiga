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

  public Area() {
    testBoxX = 300;
    testBoxY = 300;
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    GameObject image = new GameObject("floor.png", 300, 300);
    image.draw(graphics);
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
