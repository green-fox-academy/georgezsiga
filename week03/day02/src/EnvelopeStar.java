import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by georgezsiga on 3/28/17.
 */
public class EnvelopeStar {
  public static void mainDraw(Graphics graphics){
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/envelope-star/r2.png]


    drawline(graphics);
  }

  public static void drawline(Graphics graphics2) {

    graphics2.setColor(Color.BLACK);
    graphics2.drawLine(150, 0, 150, 300);
    graphics2.drawLine(0, 150, 300, 150);
// top left
    int x = 10;
    int z = 10;
    for (int i = 140; i > 0; ) {
      graphics2.setColor(Color.BLACK);
      graphics2.drawLine(150, 150-i, 150-x, 150);
      i = i - z;
      x = x + z;
    }
// bottom right
    for (int i = 140; i > 0; ) {
      graphics2.setColor(Color.GREEN);
      graphics2.drawLine(300- i, 150, 300, 300-i);
      i = i - z;
      for (int j = 140; j > 0; ) {
        graphics2.setColor(Color.BLUE);
        graphics2.drawLine(150, 300-j, 300-j, 300);
        j = j - z;
      }
    }
// top right
      for (int j = 140; j > 0; ) {
        graphics2.setColor(Color.ORANGE);
        graphics2.drawLine(150, 150-j, 300-j, 150);
        j = j - z;
    }
// bottom left
    for (int i = 140; i > 0; ) {
      graphics2.setColor(Color.MAGENTA);
      graphics2.drawLine(150 - i, 150, 150, 300-i);
      i = i - z;
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