import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/30/17.
 */
public class YellowBoxes {
  public static void mainDraw(Graphics graphics) {
    // fill the canvas with a checkerboard pattern.

    drawBox(graphics);
    drawLineBase(graphics, 0, 0, 600);
  }

  public static void drawBox(Graphics graphics) {
    graphics.setColor(Color.YELLOW);
    graphics.fillRect(0, 0, 600, 600);
    graphics.setColor(Color.BLACK);
    graphics.drawRect(0, 0, 600, 600);
  }

  public static void drawLineBase(Graphics graphics, int x, int y, int i) {
    graphics.setColor(Color.BLACK);
    graphics.drawLine(x + (i / 3), y,x + (i / 3), y + i);
    graphics.drawLine(x + ((i / 3) * 2), y , x + ((i / 3) * 2), y + i);
    graphics.drawLine(x,y + (i / 3), x + i, y + (i / 3));
    graphics.drawLine(x,y + ((i / 3) * 2), x + i, y + ((i / 3) * 2));
  }
//
//  public static void drawLineUp(Graphics graphics, int i, int n) {
//    graphics.setColor(Color.BLACK);
//    graphics.drawLine(n + i - i, i / 3, n + i, i / 3);
//    graphics.setColor(Color.RED);
//    graphics.drawLine(n + i - i, (i / 3) * 2, n + i, (i / 3) * 2);
//    graphics.setColor(Color.GREEN);
//    graphics.drawLine(n + (i / 3), i - i, n + (i / 3), i);
//    graphics.setColor(Color.BLUE);
//    graphics.drawLine(n + ((i / 3)) * 2, i - i, n + ((i / 3) * 2), i);
//  }
//
//  public static void drawLineDown(Graphics graphics, int i, int n) {
//    graphics.setColor(Color.BLACK);
//    graphics.drawLine(n + i - i, n + n + (i / 3), n + i, n + n + (i / 3));
//    graphics.setColor(Color.RED);
//    graphics.drawLine(n + i - i, n + n + (i / 3) * 2, n + i, n + n + ((i / 3) * 2));
//    graphics.setColor(Color.GREEN);
//    graphics.drawLine(n + (i / 3), n + n + i - i, n + (i / 3), n + n + i);
//    graphics.setColor(Color.BLUE);
//    graphics.drawLine(n + ((i / 3)) * 2, n + n + i - i, n + ((i / 3) * 2), n + n + i);
//  }
//
//  public static void drawLineLeft(Graphics graphics, int i, int n) {
//    graphics.setColor(Color.BLACK);
//    graphics.drawLine(i - i, n + (i / 3), i, n + (i / 3));
//    graphics.setColor(Color.RED);
//    graphics.drawLine(i - i, n + (i / 3) * 2, i, n + ((i / 3) * 2));
//    graphics.setColor(Color.GREEN);
//    graphics.drawLine((i / 3), n + i - i, (i / 3), n + i);
//    graphics.setColor(Color.BLUE);
//    graphics.drawLine(((i / 3)) * 2, n + i - i, ((i / 3) * 2), n + i);
//  }
//
//  public static void drawLineRight(Graphics graphics, int i, int n) {
//    graphics.setColor(Color.BLACK);
//    graphics.drawLine(n + n + i - i, n + (i / 3), n + n + i, n + (i / 3));
//    graphics.setColor(Color.RED);
//    graphics.drawLine(n + n + i - i, n + (i / 3) * 2, n + n + i, n + ((i / 3) * 2));
//    graphics.setColor(Color.GREEN);
//    graphics.drawLine(n + n + (i / 3), n + i - i, n + n + (i / 3), n + i);
//    graphics.setColor(Color.BLUE);
//    graphics.drawLine(n + n + ((i / 3) * 2), n + i - i, n + n + ((i / 3) * 2), n + i);
//  }
//
//  public static void fractals(Graphics graphics, int i, int n) {
//    graphics.setColor(Color.BLACK);
//    if (i < 10) {
//      return;
//    } else {
//      fractalsUp(graphics, i, n);
//      fractalsDown(graphics, i, n);
//      fractals(graphics, i, n);
//    }
//  }
//
//  public static void fractalsUp(Graphics graphics, int i, int n) {
//    graphics.setColor(Color.BLACK);
//    if (i < 10) {
//return;
//    } else {
//      drawLineUp(graphics, i, n);
//      n = n + (i / 3);
//      i = i / 3;
//      fractalsDown(graphics, i, n);
//    }
//  }
//
//  public static void fractalsDown(Graphics graphics, int i, int n) {
//    graphics.setColor(Color.BLACK);
//    if (i < 10) {
//return;
//    } else {
//      drawLineDown(graphics, i, n);
//      n = n + (i / 3);
//      i = i / 3;
//      fractalsDown(graphics, i, n);
//    }
//  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(600, 630));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
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