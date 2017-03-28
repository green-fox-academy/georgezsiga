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

//for (int slide = TIPOFTRIANGLEX-5; slide > 0;) {
//  slide-=5;
//  for (int down = TIPOFTRIANGLEY+10; down < 300;) {
//    down+=10;
    for (int i = TIPOFTRIANGLEX; i < 290; ) {
      for (int j = TIPOFTRIANGLEY; j < 290; ) {
        drawAtriangle(graphics, i, j);
        i += 5;
        j += 10;
      }
    }
        for (int i = TIPOFTRIANGLEX-5; i > 10; ) {
          for (int j = TIPOFTRIANGLEY+10; j < 290; ) {
            drawAtriangle(graphics, i, j);
            i -= 5;
            j += 10;
          }
        }
      }


//}
//  }

  public static void drawAtriangle(Graphics graphics, int i, int j){
    int xpoints[] = {i, i-5, i+5};
    int ypoints[] = {j, j+10, j+10};
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