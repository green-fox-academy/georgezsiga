import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/28/17.
 */
public class RainbowBox {
  public static void mainDraw(Graphics graphics) {
    // create a square drawing function that takes 2 parameters:
    // the square size, and the fill color,
    // and draws a square of that size and color to the center of the canvas.
    // create a loop that fills the canvas with rainbow colored squares.

    System.out.println("Give me a number between 0 and 300 and a colour in RGB (123 1 22)");
    drawline(graphics);
  }

  public static void drawline(Graphics graphics2) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int r = scanner.nextInt();
    int g = scanner.nextInt();
    int b = scanner.nextInt();
    int z = 10;
    int y = 300;
    for (int i = 300; i > (2*x);) {
      Random rand = new Random();
      int n = rand.nextInt(255) + 0;
      int n1 = rand.nextInt(255) + 0;
      int n2 = rand.nextInt(255) + 0;
      graphics2.setColor(new Color(n,n1,n2));
      graphics2.fillRect(300-i, 300-i, y, y);
      i = i -z;
      y = y - (2*z);
    }
    graphics2.setColor(new Color(r,g,b));
    graphics2.fillRect((300-x)/2, (300-x)/2, x, x);
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
