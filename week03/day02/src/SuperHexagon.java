import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/29/17.
 */
public class SuperHexagon {
  final public static int TIPOFHEXAGONX = 150;
  final public static int TIPOFHEXAGONY = 150;
  public static void mainDraw(Graphics graphics) {
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/super-hexagon/r6.gif]

    for (int i = 0; i < ; i++) {
      
    }
          drawAbeeHome(graphics, 1, 2);


  }

  public static void drawAbeeHome(Graphics graphics, int j, int i){
    int xpoints[] = {i, i+12, i+36, i+48, i+36, i+12};
    int ypoints[] = {j+21, j, j, j+21, j+42, j+42};
    int npoints = 6;
    graphics.drawPolygon(xpoints, ypoints, npoints);
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
