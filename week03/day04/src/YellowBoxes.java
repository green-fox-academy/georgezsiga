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
    }

    public static void drawBox(Graphics graphics) {
      graphics.setColor(Color.YELLOW);
      graphics.fillRect(0, 0, 600, 600);
    }

//    public static void drawLine(Graphics graphics) {
//      graphics.drawLine();
//
//
//    }

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