import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/30/17.
 */
public class Caleidoscope {

  public static void mainDraw(Graphics graphics) {
    fractals(graphics, 50, 50, 120, 210);
  }

  public static void drawAbeeHome(Graphics graphics, int j, int i, int l, int h) {
    int xpoints[] = {i, i + l, i + (3 * l), i + (4 * l), i + (3 * l), i + l};
    int ypoints[] = {j + h, j, j, j + h, j + (2 * h), j + (2 * h)};
    int npoints = 6;
    graphics.drawPolygon(xpoints, ypoints, npoints);
  }

  public static void fractals(Graphics graphics, int j, int i, int l, int h) {
    if (l < 3) {
      return;
    } else {
      drawAbeeHome(graphics, j, i, l, h);
      fractals(graphics, j, i + (l / 2), l / 2, h / 2);
      fractals(graphics, j + (h / 2), i + (2 * l), l / 2, h / 2);
      fractals(graphics, j + h, i + (l / 2), l / 2, h / 2);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Caleidoscope");
    jFrame.setSize(new Dimension(600, 630));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new Caleidoscope.ImagePanel());
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
