import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/28/17.
 */
public class ConnectTheDots {
  public static void mainDraw(Graphics graphics){
    // create a function that takes 1 parameter:
    // an array of {x, y} points
    // and connects them with green lines.
    // connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
    // connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
    // {120, 100}, {85, 130}, {50, 100}}


    polygon(graphics);
  }

  public static void polygon(Graphics graphics3){
    int xpoints[] = {25, 145, 25, 145, 25};
    int ypoints[] = {25, 25, 145, 145, 25};
    int npoints = 5;

    graphics3.drawPolygon(xpoints, ypoints, npoints);
  }

//  public static void drawline(Graphics graphics2) {
//    List<Integer> coordinates = new ArrayList<>();
//    List<Integer> temp = Arrays.asList(10, 10, 20, 20);
//
//    coordinates.addAll(temp);
//    graphics2.setColor(Color.BLACK);
//    graphics2.drawLine(coordinates.indexOf(0), coordinates.indexOf(1), coordinates.indexOf(2), coordinates.indexOf(3));
//  }



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
