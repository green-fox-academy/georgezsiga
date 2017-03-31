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
    drawAline(graphics, 450, 870, -90, 40);
    fractals(graphics, 450, 870, -90, 40);
  }

  public static void drawAline(Graphics graphics, double startX, double startY, double angle, int l) {
    graphics.setColor(Color.YELLOW);
    double x = startX + l * Math.cos(Math.toRadians(angle));
    double y= startY + l * Math.sin(Math.toRadians(angle));
    graphics.drawLine((int)startX, (int)startY, (int)x, (int)y);
  }

  public static void fractals(Graphics graphics, double startX, double startY, double angle, int l) {
    if (l < 1 ) {
      return;
    } else {
      drawAline(graphics, startX, startY, angle, l);
      fractals(graphics, startX, startY - l, angle, l-1);
//      fractals(graphics, X, Y, angle + 20, l);
//      fractals(graphics, X, Y, angle - 20, l);
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
