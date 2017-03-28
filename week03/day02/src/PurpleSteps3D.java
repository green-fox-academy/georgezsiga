import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/28/17.
 */
public class PurpleSteps3D {
  public static void mainDraw(Graphics graphics){
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/purple-steps-3d/r4.png]

    drawline(graphics);
  }

  public static void drawline(Graphics graphics2) {
    int z = 0;
      for (int i = 290; i > 150; ) {
        i = i - z;
        z = z+10;
        graphics2.setColor(Color.BLACK);
        graphics2.fillRect(300 - i, 300 - i, z, z);
        graphics2.setColor(new Color(153, 58, 164));
        graphics2.fillRect(300 - i + 1, 300 - i + 1, z - 2, z - 2);
      }

  }
  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(300, 300));
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
