import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/28/17.
 */
public class Triangles {
  public static void mainDraw(Graphics graphics) {
    fractals(graphics, 150, 0, 10);
  }

  public static void drawAtriangle(Graphics graphics, int i, int j, int l){
    int xpoints[] = {i+l, i, i+(2*l)};
    int ypoints[] = {j, j+(2*l), j+(2*l)};
    int npoints = 3;
    graphics.drawPolygon(xpoints, ypoints, npoints);
  }

  public static void fractals(Graphics graphics, int i, int j, int l) {
    if (i <= 0 ||  j > 280) {
      return;
    } else {
      drawAtriangle(graphics, i, j, l);
      fractals(graphics, i - 10, j + 20, l);
      fractals(graphics, i + 10, j + 20, l);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(400, 400));
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