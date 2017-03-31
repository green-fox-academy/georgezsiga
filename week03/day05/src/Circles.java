import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by georgezsiga on 3/31/17.
 */
public class Circles {
  public static void mainDraw(Graphics graphics) {
    drawAcircle(graphics, 150, 150, 600, 600);
//    fractals(graphics, 450, 700, 300, 260);
  }

  public static void drawAcircle(Graphics graphics, int x, int y, int a, int b) {
    graphics.drawOval( x, y, a, b);
  }

//  public static void fractals(Graphics graphics, int x, int y, int l, int h) {
//    if (l < 3) {
//      return;
//    } else {
//      drawAtriangle(graphics, x, y, l, h);
//      graphics.setColor(Color.BLUE);
//      fractals(graphics, x, y, l/2, h/2);
//      graphics.setColor(Color.GREEN);
//      fractals(graphics, x - (l/2), y - h, l/2, h/2);
//      graphics.setColor(Color.RED);
//      fractals(graphics, x + (l/2), y - h, l/2, h/2);
//    }
//  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Circles");
    jFrame.setSize(new Dimension(900, 930));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new Circles.ImagePanel());
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