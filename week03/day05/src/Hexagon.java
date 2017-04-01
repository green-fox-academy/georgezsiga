import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/31/17.
 */

public class Hexagon {

  public static void mainDraw(Graphics graphics) {
    fractals(graphics, 50, 50, 120, 210);
  }

  public static int randomColor() {
    int randomColor = (int) (Math.random() * 256);
    return randomColor;
  }

  public static void drawAbeeHome(Graphics graphics, int x, int y, int l, int h) {
    int xpoints[] = {x, x + l, x + (3 * l), x + (4 * l), x + (3 * l), x + l};
    int ypoints[] = {y + h, y, y, y + h, y + (2 * h), y + (2 * h)};
    int npoints = 6;
    graphics.drawPolygon(xpoints, ypoints, npoints);
  }

  public static void fractals(Graphics graphics, int x, int y, int l, int h) {
    if (h < 1) {
      return;
    } else {
      graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
      drawAbeeHome(graphics, x, y, l, h);
      fractals(graphics, x + l - (l / 3), y, l / 3, h / 3);
      fractals(graphics, x + (2 * l), y, l / 3, h / 3);
      fractals(graphics, x + l - (l / 3), y + h + (h / 3), l / 3, h / 3);
      fractals(graphics, x + (2 * l), y + h + (h / 3), l / 3, h / 3);
      fractals(graphics, x + (2 * l) + ((l / 3) * 2), y + h - (h / 3), l / 3, h / 3);
      fractals(graphics, x, y + h - (h / 3), l / 3, h / 3);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Hexagon");
    jFrame.setSize(new Dimension(600, 630));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new Hexagon.ImagePanel());
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