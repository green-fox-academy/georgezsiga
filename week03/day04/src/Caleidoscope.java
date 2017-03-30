import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/30/17.
 */
public class Caleidoscope {
  public static void mainDraw(Graphics graphics) {
    // fill the canvas with a checkerboard pattern.
    drawBox(graphics);
    fractals(graphics, 0, 0, 600);
  }

  public static void drawBox(Graphics graphics) {
    graphics.setColor(Color.YELLOW);
    graphics.fillRect(0, 0, 600, 600);
    graphics.setColor(Color.BLACK);
    graphics.drawRect(0, 0, 600, 600);
  }

  public static void drawLineBase(Graphics graphics, int x, int y, int i) {
    graphics.setColor(Color.BLACK);
    graphics.drawLine(x + (i / 3), y, x + (i / 3), y + i);
    graphics.drawLine(x + ((i / 3) * 2), y, x + ((i / 3) * 2), y + i);
    graphics.drawLine(x, y + (i / 3), x + i, y + (i / 3));
    graphics.drawLine(x, y + ((i / 3) * 2), x + i, y + ((i / 3) * 2));
  }

  public static void fractals(Graphics graphics, int x, int y, int i) {
    if (i < 1) {
      return;
    } else {
      drawLineBase(graphics, x, y, i);
      fractals(graphics, x + (i / 3), y, i / 3);
      fractals(graphics, x, y + (i / 3), i / 3);
      fractals(graphics, x + ((i / 3) * 2), y + (i / 3), i / 3);
      fractals(graphics, x + (i / 3), y + ((i / 3) * 2), i / 3);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(600, 630));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new YellowBoxes.ImagePanel());
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
