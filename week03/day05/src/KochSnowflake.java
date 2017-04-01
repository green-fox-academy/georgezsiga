import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by georgezsiga on 4/1/17.
 */
public class KochSnowflake {
  public static void mainDraw(Graphics graphics) {

    fractals(graphics, 30, 300, 0, 100, 3);

//    drawAkoch(graphics, 30, 300, 0,40);
  }

  public static int randomColor() {
    int randomColor = (int) (Math.random() * 256);
    return randomColor;
  }

  public static void drawAkoch(Graphics graphics, double startX, double startY, double angle, double length) {
    graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
    double x = startX + length * Math.cos(Math.toRadians(angle));
    double y = startY + length * Math.sin(Math.toRadians(angle));
    graphics.drawLine((int) startX, (int) startY, (int) x, (int) y);
    graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
    double x1 = x + length * Math.cos(Math.toRadians(angle-60));
    double y1 = y + length * Math.sin(Math.toRadians(angle-60));
    graphics.drawLine((int) x, (int) y, (int) x1, (int) y1);
    graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
    double x2 = x1 + length * Math.cos(Math.toRadians(angle+60));
    double y2 = y1 + length * Math.sin(Math.toRadians(angle+60));
    graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    double x3 = x2 + length * Math.cos(Math.toRadians(angle));
    double y3 = y2 + length * Math.sin(Math.toRadians(angle));
    graphics.drawLine((int) x2, (int) y2, (int) x3, (int) y3);
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
      graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
      double x1 = x + length * Math.cos(Math.toRadians(angle-60));
      double y1 = y + length * Math.sin(Math.toRadians(angle-60));
      graphics.drawLine((int) x, (int) y, (int) x1, (int) y1);
      graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
      double x2 = x1 + length * Math.cos(Math.toRadians(angle+60));
      double y2 = y1 + length * Math.sin(Math.toRadians(angle+60));
      graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
      double x3 = x2 + length * Math.cos(Math.toRadians(angle));
      double y3 = y2 + length * Math.sin(Math.toRadians(angle));
      graphics.drawLine((int) x2, (int) y2, (int) x3, (int) y3);

      fractals(graphics, x3, y3, angle - 60, length, loop - 1);
      fractals(graphics, startX, startY, angle, length /3, loop - 1);
      fractals(graphics, x3+ length + length/2, y3- 2*length - (length/2
      ), angle + 60, length, loop - 1);
      fractals(graphics, x3 + 3*length, y3, angle, length, loop - 1);

    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("KochSnowflake");
    jFrame.setSize(new Dimension(600, 630));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new KochSnowflake.ImagePanel());
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