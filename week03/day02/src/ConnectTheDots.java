import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/28/17.
 */
public class ConnectTheDots {

  public static void mainDraw(Graphics graphics) {
    // create a function that takes 1 parameter:
    // an array of {x, y} points
    // and connects them with green lines.
    // connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
    // connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
    // {120, 100}, {85, 130}, {50, 100}}
    int[][] coordinates = {{10, 10}, {290, 10}, {290, 290}, {10, 290}};
    polygon(graphics, coordinates);
    int[][] coordinates2 = {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100},
        {85, 130}, {50, 100}};
    polygon(graphics, coordinates2);
  }

  public static void polygon(Graphics graphics, int[][] coordinates) {
    int[] xpoints = new int[coordinates.length];
    int[] ypoints = new int[coordinates.length];
    int npoints = coordinates.length;
    graphics.setColor(Color.GREEN);
    for (int i = 0; i < coordinates.length; i++) {
      xpoints[i] = coordinates[i][0];
      ypoints[i] = coordinates[i][1];
    }
    graphics.drawPolygon(xpoints, ypoints, npoints);
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(330, 330));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

  static class ImagePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);

    }
  }

}
