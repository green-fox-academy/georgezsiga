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
    graphics.setColor(Color.BLACK);
    drawAline(graphics, 450, 800, 50);
//    fractals(graphics, 150, 150, 600, 600);
  }

  public static void drawAline(Graphics graphics, int x, int y, int l) {
    graphics.drawLine(x, y, x, y+l);
  }

//  public static void fractals(Graphics graphics, int x, int y, int a, int b) {
//    if (a < 3) {
//      return;
//    } else {
//      drawAcircle(graphics, x, y, a, b);
//      graphics.setColor(Color.BLUE);
//      fractals(graphics, x + (a / 4), y, a / 2, b / 2);
//      graphics.setColor(Color.GREEN);
//      fractals(graphics, x + ((a / 2) - (a / 30)), y + ((a / 2) - (a / 8)), a / 2, b / 2);
//      graphics.setColor(Color.RED);
//      fractals(graphics, x + (a / 30), y + ((a / 2) - (a / 8)), a / 2, b / 2);
//    }
//  }

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
      mainDraw(graphics);

    }
  }

}
