import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/28/17.
 */
public class FunctionToCenter {
  public static void mainDraw(Graphics graphics){
    // create a line drawing function that takes 2 parameters:
    // the x and y coordinates of the line's starting point
    // and draws a line from that point to the center of the canvas.
    // fill the canvas with lines from the edges, every 20 px, to the center.
    System.out.println("Give me 2 numbers between 0 and 300 (x y)");
    drawline(graphics);
  }

  public static void drawline(Graphics graphics2) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    int z = 20;
      for (int i = 300; i >= 0; ) {
        graphics2.setColor(Color.BLACK);
        graphics2.drawLine(300 - i, 0, 150, 150);
        i = i - z;
        for (int j = 300; j >= 0; ) {
          graphics2.setColor(Color.RED);
          graphics2.drawLine(150, 150, 300, 300 -j);
          j = j - z;
        }
      }
    int q = 20;
    for (int i = 300; i >= 0; ) {
      graphics2.setColor(Color.GREEN);
      graphics2.drawLine(0, 300-i, 150, 150);
      i = i - q;
      for (int j = 300; j >= 0; ) {
        graphics2.setColor(Color.YELLOW);
        graphics2.drawLine(150, 150, 300-j, 300);
        j = j - q;
      }
    }
    graphics2.setColor(Color.BLUE);
    graphics2.drawLine(x, y, 150, 150);
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