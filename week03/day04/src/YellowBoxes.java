import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/30/17.
 */
public class YellowBoxes {
    public static void mainDraw(Graphics graphics) {
      // fill the canvas with a checkerboard pattern.
      int i = 600;
      drawBox(graphics);
      drawLine(graphics);
      fractals(graphics, i);
    }

    public static void drawBox(Graphics graphics) {
      graphics.setColor(Color.YELLOW);
      graphics.fillRect(0, 0, 600, 600);
      graphics.setColor(Color.BLACK);
      graphics.drawRect(0, 0, 600, 600);

    }

  public static void drawLine(Graphics graphics) {
      graphics.setColor(Color.BLACK);
      graphics.drawLine(0, 200, 600, 200);
      graphics.drawLine(0, 400, 600, 400);
      graphics.drawLine(200, 0, 200, 600);
      graphics.drawLine(400, 0, 400, 600);
    }


    public static Object fractals(Graphics graphics, int i) {
      graphics.setColor(Color.BLACK);
      if (i == 0) {
        return 0;
      } else {
        graphics.drawLine(i - i, i / 3, i, i / 3);
        graphics.drawLine(i - i, (i / 3) * 2, i, (i / 3) * 2);
        graphics.drawLine(i / 3, i - i, i / 3, i);
        graphics.drawLine((i / 3) * 2, i - i, (i / 3) * 2, i);
        i = i / 3;
        return fractals(graphics, i);
      }
    }

    //    Don't touch the code below
    public static void main(String[] args) {
      JFrame jFrame = new JFrame("Drawing");
      jFrame.setSize(new Dimension(600, 630));
      jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      jFrame.add(new ImagePanel());
      jFrame.setLocationRelativeTo(null);
      jFrame.setVisible(true);
    }
    static class ImagePanel extends JPanel{
      @Override
      protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        mainDraw(graphics);

      }
    }

  }