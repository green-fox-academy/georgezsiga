import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/28/17.
 */
public class FourRectangles {
  public static void mainDraw(Graphics graphics){
    // draw four different size and color rectangles.

    graphics.setColor(Color.GREEN);
    graphics.fillRect(145, 145, 10, 10);
    graphics.setColor(Color.RED);
    graphics.fillRect(0,0,100, 100);
    graphics.setColor(Color.BLUE);
    graphics.fillRect(250, 250, 50, 50);
    graphics.setColor(Color.BLACK);
    graphics.fillRect(30, 180, 70, 70);

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
