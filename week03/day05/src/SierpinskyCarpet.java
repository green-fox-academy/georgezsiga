import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by georgezsiga on 3/31/17.
 */
public class SierpinskyCarpet {
  public static void mainDraw(Graphics graphics) {
    drawBox(graphics, 400, 400, 100);
    fractals(graphics, 400, 400, 100);
  }

  public static void drawBox(Graphics graphics, int x, int y, int l) {
    graphics.setColor(Color.RED);
    graphics.fillRect(x-l, y-l, 2*l, 2*l);
  }

  public static void fractals(Graphics graphics, int x, int y, int l) {
    if (l < 1) {
      return;
    } else {
      drawBox(graphics, x, y, l);
      graphics.setColor(Color.GREEN);
      fractals(graphics, x-(2*l), y, l/3);
      fractals(graphics, x-(2*l), y-(2*l), l/3);
      fractals(graphics, x+(2*l), y, l/3);
      fractals(graphics, x+(2*l), y+(2*l), l/3);
      fractals(graphics, x, y+(2*l), l/3);
      fractals(graphics, x, y-(2*l), l/3);
      fractals(graphics, x+(2*l), y-(2*l), l/3);
      fractals(graphics, x-(2*l), y+(2*l), l/3);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("SierpinskyCarpet");
    jFrame.setSize(new Dimension(800, 830));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new SierpinskyCarpet.ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);

    }
  }

}
