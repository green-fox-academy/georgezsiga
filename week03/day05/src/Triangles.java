import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/31/17.
 */
public class Triangles {

  public static void mainDraw(Graphics graphics) {
    fractals(graphics, 300, 0, 100);
  }

  public static void drawAtriangle(Graphics graphics, int i, int j, int l) {
    int xpoints[] = {i + l, i, i + (2 * l)};
    int ypoints[] = {j, j + (2 * l), j + (2 * l)};
    int npoints = 3;
    graphics.drawPolygon(xpoints, ypoints, npoints);
  }

  public static void fractals(Graphics graphics, int i, int j, int l) {
    if (l < 3) {
      return;
    } else {
      drawAtriangle(graphics, i, j, l);
      fractals(graphics, i/3, j, l/2);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Triangles");
    jFrame.setSize(new Dimension(600, 630));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new Triangles.ImagePanel());
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