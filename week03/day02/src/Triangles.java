import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/28/17.
 */
public class Triangles {
  final public static int TIPOFTRIANGLEX = 150;
  final public static int TIPOFTRIANGLEY = 0;
  public static void mainDraw(Graphics graphics) {
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/triangles/r5.png]

    for (int inside = 0; inside < 140;) {
      for (int insideOther = 0; insideOther < 290;) {
        for (int i = TIPOFTRIANGLEX; i > 0;) {
          for (int j = TIPOFTRIANGLEY; j < 300;) {
            if (j+insideOther < 300) {
            drawAtriangle(graphics, i, j, insideOther, inside);
            i -= 5;
            j += 10;
            } else {
              i -= 5;
              j += 10;
            }
          }
        }
        inside += 5;
        insideOther += 10;
      }
    }
  }

  public static void drawAtriangle(Graphics graphics, int i, int j, int insideOther, int inside){
    int xpoints[] = {i+inside, i-5+inside, i+5+inside};
    int ypoints[] = {j+insideOther, j+10+insideOther, j+10+insideOther};
    int npoints = 3;
    graphics.drawPolygon(xpoints, ypoints, npoints);
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