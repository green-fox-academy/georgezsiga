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
      drawLine(graphics);
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