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

    fractals(graphics, 30, 150, 0, 100, 4);

    drawAtriangle(graphics, 30, 200, 0, 100);
  }

  public static int randomColor() {
    int randomColor = (int) (Math.random() * 256);
    return randomColor;
  }

  public static void drawAtriangle(Graphics graphics, double startX, double startY, double angle, double length) {
    graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
    double x = startX + length * Math.cos(Math.toRadians(angle));
    double y = startY + length * Math.sin(Math.toRadians(angle));
    graphics.drawLine((int) startX, (int) startY, (int) x, (int) y);
    graphics.setColor(Color.WHITE);
    double xw = x + length * Math.cos(Math.toRadians(angle));
    double yw = y + length * Math.sin(Math.toRadians(angle));
    graphics.drawLine((int) x, (int) y, (int) xw, (int) yw);
    graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
    double x1 = x + length * Math.cos(Math.toRadians(angle-60));
    double y1 = y + length * Math.sin(Math.toRadians(angle-60));
    graphics.drawLine((int) x, (int) y, (int) x1, (int) y1);
    double x2 = x1 + length * Math.cos(Math.toRadians(angle+60));
    double y2 = y1 + length * Math.sin(Math.toRadians(angle+60));
    graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    double x3 = x2 + length * Math.cos(Math.toRadians(angle));
    double y3 = y2 + length * Math.sin(Math.toRadians(angle));
    graphics.drawLine((int) x2, (int) y2, (int) x3, (int) y3);

    double x4 = x3 + length * Math.cos(Math.toRadians(angle+120));
    double y4 = y3 + length * Math.sin(Math.toRadians(angle+120));
    graphics.drawLine((int) x3, (int) y3, (int) x4, (int) y4);
    double x5 = x4 + length * Math.cos(Math.toRadians(angle+60));
    double y5 = y4 + length * Math.sin(Math.toRadians(angle+60));
    graphics.drawLine((int) x4, (int) y4, (int) x5, (int) y5);
    double x6 = x5 - length * Math.cos(Math.toRadians(angle));
    double y6 = y5 - length * Math.sin(Math.toRadians(angle));
    graphics.drawLine((int) x5, (int) y5, (int) x6, (int) y6);
    double x7 = x6 + length * Math.cos(Math.toRadians(angle+120));
    double y7 = y6 + length * Math.sin(Math.toRadians(angle+120));
    graphics.drawLine((int) x6, (int) y6, (int) x7, (int) y7);

    double x8 = x7 - length * Math.cos(Math.toRadians(angle+60));
    double y8 = y7 - length * Math.sin(Math.toRadians(angle+60));
    graphics.drawLine((int) x7, (int) y7, (int) x8, (int) y8);
    double x9 = x8 - length * Math.cos(Math.toRadians(angle));
    double y9 = y8 - length * Math.sin(Math.toRadians(angle));
    graphics.drawLine((int) x8, (int) y8, (int) x9, (int) y9);
    double x10 = x9 + length * Math.cos(Math.toRadians(angle-60));
    double y10 = y9 + length * Math.sin(Math.toRadians(angle-60));
    graphics.drawLine((int) x9, (int) y9, (int) x10, (int) y10);
    double x11 = x10 - length * Math.cos(Math.toRadians(angle+60));
    double y11 = y10 - length * Math.sin(Math.toRadians(angle+60));
    graphics.drawLine((int) x10, (int) y10, (int) x11, (int) y11);
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
      graphics.setColor(Color.WHITE);
      double xw = x + length * Math.cos(Math.toRadians(angle));
      double yw = y + length * Math.sin(Math.toRadians(angle));
      graphics.drawLine((int) x, (int) y, (int) xw, (int) yw);
      graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
      double x1 = x + length * Math.cos(Math.toRadians(angle-60));
      double y1 = y + length * Math.sin(Math.toRadians(angle-60));
      graphics.drawLine((int) x, (int) y, (int) x1, (int) y1);
      double x2 = x1 + length * Math.cos(Math.toRadians(angle+60));
      double y2 = y1 + length * Math.sin(Math.toRadians(angle+60));
      graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
      double x3 = x2 + length * Math.cos(Math.toRadians(angle));
      double y3 = y2 + length * Math.sin(Math.toRadians(angle));
      graphics.drawLine((int) x2, (int) y2, (int) x3, (int) y3);

      fractals(graphics, startX, startY, angle, length/3, loop - 1);
      fractals(graphics, x2, y2, angle, length/3, loop - 1);
      fractals(graphics, x, y, angle - 60, length/3, loop - 1);
      fractals(graphics, x1, y1, angle + 60, length/3, loop - 1);

//      fractals(graphics, x3, y3, angle - 60, length, loop - 1);
//      fractals(graphics, startX, startY, angle, length /3, loop - 1);
//      fractals(graphics, x1, y1, angle + 60, length/3, loop - 1);
//      fractals(graphics, x3 + 3*length, y3, angle, length, loop - 1);

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
      setBackground(Color.WHITE);
      mainDraw(graphics);

    }
  }

}