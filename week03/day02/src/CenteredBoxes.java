import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/28/17.
 */
public class CenteredBoxes {

  public static void mainDraw(Graphics graphics){
    // create a square drawing function that takes 1 parameter:
    // the square size
    // and draws a square of that size to the center of the canvas.
    // draw 3 squares with that function.
    System.out.println("Give me a number between 0 and 300");
    graphics.setColor(Color.RED);
    drawline(graphics);
    System.out.println("Give me a number between 0 and 300");
    graphics.setColor(Color.BLACK);
    drawline(graphics);
    System.out.println("Give me a number between 0 and 300");
    graphics.setColor(Color.GREEN);
    drawline(graphics);

  }

  public static void drawline(Graphics graphics2) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    graphics2.fillRect((300-x)/2, (300-x)/2, x, x);
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(300, 330));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new CenteredBoxes.ImagePanel());
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

