import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by georgezsiga on 3/27/17.
 */
public class HomeworkExcercisePractice extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setBackground(Color.YELLOW);   // set background colour

    g.setColor(Color.BLUE);   // the capital color means it it constans... set the constatns drawing colour

    g.fillRect(25,25, 100, 30);  // x -right, y-down coordinates, where the object starts, than width, and height

    g.setColor(new Color(190,81,215)); // set a new RGB colour
    g.fillRect(25, 65, 100, 30);  // this one will have the previous fill colour settings

    g.setColor(Color.RED);
    g.drawString("this is some text", 25, 120);

    g.setColor(Color.BLUE);
    g.drawLine(10,25,200,45);

    g.setColor(Color.CYAN);
    g.drawRect(10,55,100,30);

    g.setColor(Color.DARK_GRAY);
    g.fillOval(10,95,100, 30);

    g.setColor(Color.GREEN);
    g.fill3DRect(10, 160, 100, 50, true);

  }
}
