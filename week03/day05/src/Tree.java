import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by georgezsiga on 3/31/17.
 */
public class Tree {

  public static void mainDraw(Graphics graphics) {
    fractals(graphics, 450, 870, -90, 40, 15);
  }

  public static int randomColor() {
    int randomColor = (int) (Math.random() * 256);
    return randomColor;
  }

  public static void fractals(Graphics graphics, double startX, double startY, double angle,
      int length, int loop) {
    if (loop == 0) {
      return;
    } else {
      graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
      double x = startX + length * Math.cos(Math.toRadians(angle));
      double y = startY + length * Math.sin(Math.toRadians(angle));
      graphics.drawLine((int) startX, (int) startY, (int) x, (int) y);
      fractals(graphics, x, y, angle, length - 1, loop - 1);
      fractals(graphics, x, y, angle + 10, length - 1, loop - 1);
      fractals(graphics, x, y, angle - 10, length - 1, loop - 1);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Tree");
    jFrame.setSize(new Dimension(900, 930));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new Tree.ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

  static class ImagePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      this.setBackground(Color.BLACK);
      mainDraw(graphics);

    }
  }

}
