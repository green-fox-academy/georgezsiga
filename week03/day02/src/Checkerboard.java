import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/28/17.
 */
public class Checkerboard {
  public static void mainDraw(Graphics graphics) {
    // fill the canvas with a checkerboard pattern.
    drawline(graphics);
  }

  public static void drawline(Graphics graphics2) {
    int z = 20;
    for (int k = 300; k > 0 ;) {
      for (int i = 300; i > 0; ) {
        i = i - z;
        graphics2.setColor(Color.BLACK);
        graphics2.fillRect(300 - i, 300-k, 10, 10);
        for (int j = 300; j > 0; ) {
          graphics2.setColor(Color.BLACK);
          graphics2.fillRect(300-k, 300 - j, 10, 10);
          j = j - z;
        }
      }
      k = k - (z/2);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(300, 330));
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