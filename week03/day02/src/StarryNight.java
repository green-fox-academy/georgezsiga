import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/28/17.
 */
public class StarryNight {
  final public static int SCREENSIZE = 300;
  final public static int STARSIZE = 5;
  final public static int MINSTARS = 50;
  final public static int MAXSTARS = 150;

  public static void mainDraw(Graphics graphics) {
    // draw the night sky:
    // - The background should be black
    // - The stars can be small squares
    // - The stars should have random positions on the canvas
    // - The stars should have random color (some shade of grey)

    int numberOfStars = generateNumberOfStars(graphics);
    for (int i = 0; i <numberOfStars ; i++) {
      generateRandomColor(graphics);
      int x = generateRandomNumber(graphics);
      int y = generateRandomNumber(graphics);
      graphics.fillRect(x, y, STARSIZE, STARSIZE);
    }
  }
  public static int generateNumberOfStars(Graphics randomStars){
    Random randomNrStars = new Random();
    int ns = randomNrStars.nextInt(MAXSTARS - MINSTARS + 1) + MINSTARS;
    return ns;
  }
  public static int generateRandomNumber(Graphics random){
    Random randomNumber = new Random();
    int r = randomNumber.nextInt(SCREENSIZE - STARSIZE + 1) + STARSIZE;
    return r;
  }
  public static void generateRandomColor(Graphics graphics2) {
    Random rand = new Random();
    int n = rand.nextInt(220 - 120 + 1) + 120;
    graphics2.setColor(new Color(n,n,n));
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