import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/28/17.
 */
public class StarryNight {
  final static int SCREENSIZE = 300;
  final static int STARSIZE = 10;

  public static void mainDraw(Graphics graphics) {
    // draw the night sky:
    // - The background should be black
    // - The stars can be small squares
    // - The stars should have random positions on the canvas
    // - The stars should have random color (some shade of grey)


    int x = generateRandomNumber(graphics);
    int y = generateRandomNumber(graphics);

  }

  public static int generateRandomNumber(Graphics random){
    Random rand = new Random();
    int r = rand.nextInt(SCREENSIZE-STARSIZE) + 0;
    return r;
  }
  public static void drawAstar(Graphics graphics, int x, int y){
    graphics.setColor(Color.GREEN);
    graphics.fillRect(x, y, STARSIZE, STARSIZE);
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
      this.setBackground(Color.BLACK);
      mainDraw(graphics);

    }
  }

}