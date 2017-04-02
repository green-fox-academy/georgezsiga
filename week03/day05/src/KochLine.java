import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by georgezsiga on 4/3/17.
 */
public class KochLine {
  public static void mainDraw(Graphics graphics) {
    fractals(graphics, 30, 300, 0, 180, 3);
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
      graphics.setColor(Color.BLACK);
//      graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
      double x = startX + length * Math.cos(Math.toRadians(angle));
      double y = startY + length * Math.sin(Math.toRadians(angle));
      graphics.drawLine((int) startX, (int) startY, (int) x, (int) y);
//      graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
      graphics.setColor(Color.WHITE);
      double xw = x + length * Math.cos(Math.toRadians(angle));
      double yw = y + length * Math.sin(Math.toRadians(angle));
      graphics.drawLine((int) x, (int) y, (int) xw, (int) yw);
      graphics.setColor(Color.BLACK);
//      graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
      double x1 = x + length * Math.cos(Math.toRadians(angle-60));
      double y1 = y + length * Math.sin(Math.toRadians(angle-60));
      graphics.drawLine((int) x, (int) y, (int) x1, (int) y1);
//      graphics.setColor(new Color(randomColor(), randomColor(), randomColor()));
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
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("KochLine");
    jFrame.setSize(new Dimension(600, 630));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new KochLine.ImagePanel());
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