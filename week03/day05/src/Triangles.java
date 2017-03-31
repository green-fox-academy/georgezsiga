import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/31/17.
 */
public class Triangles {
  public static void mainDraw(Graphics graphics) {
    drawAtriangle(graphics, 450, 700, 300, 260);
    fractals(graphics, 450, 700, 300, 260);
  }

  public static void drawAtriangle(Graphics graphics, int x, int y, int l, int h) {
    int xpoints[] = {x, x - l, x + l};
    int ypoints[] = {y, y - (2*h), y - (2*h)};
    int npoints = 3;
    graphics.drawPolygon(xpoints, ypoints, npoints);
  }

  public static void fractals(Graphics graphics, int x, int y, int l, int h) {
    if (l < 3) {
      return;
    } else {
      drawAtriangle(graphics, x, y, l, h);
      graphics.setColor(Color.BLUE);
      fractals(graphics, x, y, l/2, h/2);
      graphics.setColor(Color.GREEN);
      fractals(graphics, x - (l/2), y - h, l/2, h/2);
      graphics.setColor(Color.RED);
      fractals(graphics, x + (l/2), y - h, l/2, h/2);
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