import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by georgezsiga on 3/31/17.
 */
public class SquareGrid {

  public static void mainDraw(Graphics graphics) {
    fractals(graphics, 400, 400, 100, 20);
  }

  public static int randomColor() {
    int randomColor = (int) (Math.random() * 256);
    return randomColor;
  }

  public static void drawBox(Graphics graphics, int x, int y, int l, float w) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setStroke(new BasicStroke(w));
    graphics.drawRect(x - l, y - l, 2 * l, 2 * l);
  }

  public static void fractals(Graphics graphics, int x, int y, int l, float w) {
    if (l < 4) {
      return;
    } else {
      graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
      drawBox(graphics, x, y, l, w);
      fractals(graphics, x - l, y - l, l / 2, w / 2);
      fractals(graphics, x + l, y + l, l / 2, w / 2);
      fractals(graphics, x + l, y - l, l / 2, w / 2);
      fractals(graphics, x - l, y + l, l / 2, w / 2);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("SquareGrid");
    jFrame.setSize(new Dimension(800, 830));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new SquareGrid.ImagePanel());
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
