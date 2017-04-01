import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/29/17.
 */
public class SuperHexagon {

  public static void mainDraw(Graphics graphics) {
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/super-hexagon/r6.gif]
    fractals(graphics, 170, 170, 12, 21, 4);
  }

  public static void drawAbeeHome(Graphics graphics, int x, int y, int l, int h) {
    int xpoints[] = {x, x + l, x + (3 * l), x + (4 * l), x + (3 * l), x + l};
    int ypoints[] = {y + h, y, y, y + h, y + (2 * h), y + (2 * h)};
    int npoints = 6;
    graphics.drawPolygon(xpoints, ypoints, npoints);
  }

  public static void fractals(Graphics graphics, int x, int y, int length, int height, int loop) {
    if (loop == 0) {

    } else {
      drawAbeeHome(graphics, x, y, length, height);
      fractals(graphics, x, y + 2 * height, length, height, loop - 1);
      fractals(graphics, x, y - 2 * height, length, height, loop - 1);
      fractals(graphics, x + 3 * length, y - height, length, height, loop - 1);
      fractals(graphics, x + 3 * length, y + height, length, height, loop - 1);
      fractals(graphics, x - 3 * length, y + height, length, height, loop - 1);
      fractals(graphics, x - 3 * length, y - height, length, height, loop - 1);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(400, 430));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
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
