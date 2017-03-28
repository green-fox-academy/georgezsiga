import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/28/17.
 */
public class PositionSquare {
  public static void mainDraw(Graphics graphics){
    // create a square drawing function that takes 2 parameters:
    // the x and y coordinates of the square's top left corner
    // and draws a 50x50 square from that point.
    // draw 3 squares with that function.
    System.out.println("Give me 2 numbers between 0 and 250 (x y)");
    graphics.setColor(Color.RED);
    drawline(graphics);
    System.out.println("Give me 2 numbers between 0 and 250 (x y)");
    graphics.setColor(Color.BLACK);
    drawline(graphics);
    System.out.println("Give me 2 numbers between 0 and 250 (x y)");
    graphics.setColor(Color.GREEN);
    drawline(graphics);

  }

  public static void drawline(Graphics graphics2) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    graphics2.fillRect(x, y, 50, 50);
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
