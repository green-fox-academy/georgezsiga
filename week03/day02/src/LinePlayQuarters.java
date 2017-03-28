import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by georgezsiga on 3/28/17.
 */
public class LinePlayQuarters {
  public static void mainDraw(Graphics graphics){
    // divide the canvas into 4 parts
    // and repeat this pattern in each quarter:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/line-play/r1.png]

    drawline(graphics);
  }

  public static void drawline(Graphics graphics2) {

    graphics2.setColor(Color.BLACK);
    graphics2.drawLine(150, 0, 150, 300);
    graphics2.drawLine(0, 150, 300, 150);

    int z = 20;
    for (int i = 290; i > 0; ) {
      graphics2.setColor(Color.BLACK);
      graphics2.drawLine(300 - i, 0, 300, 300-i);
      i = i - z;
      for (int j = 290; j > 0; ) {
        graphics2.setColor(Color.RED);
        graphics2.drawLine(0, 300-j, 300-j, 300);
        j = j - z;
      }
    }
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