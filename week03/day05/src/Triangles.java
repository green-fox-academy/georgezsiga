import javax.swing.*;
import java.awt.*;

import static java.lang.Math.sqrt;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/31/17.
 */
public class Triangles {
  public static void mainDraw(Graphics graphics) {
    drawAtriangle(graphics, 450, 450, 150, 130 );
//    fractals(graphics, 300, 0, 100);
  }

//  public static void drawAtriangle(Graphics graphics, int i, int j, int l) {
//    int xpoints[] = {i + l, i, i + (2 * l)};
//    int ypoints[] = {j, j + (2 * l), j + (2 * l)};
//    int npoints = 3;
//    graphics.drawPolygon(xpoints, ypoints, npoints);
//  }

  public static void drawAtriangle(Graphics graphics, int x, int y, int l, int h) {
    int xpoints[] = {x, x - l, x + l};
    int ypoints[] = {y - h, y + h, y + h};
    int npoints = 3;
    graphics.drawPolygon(xpoints, ypoints, npoints);
  }


  public static void fractals(Graphics graphics, int x, int y, int l, int h) {
    if (l < 3) {
      return;
    } else {
      drawAtriangle(graphics, x, y, l, h);
      fractals(graphics, x / 3, y, l / 2, h);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Triangles");
    jFrame.setSize(new Dimension(900, 930));
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