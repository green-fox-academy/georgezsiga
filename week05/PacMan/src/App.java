import javax.swing.JFrame;

/**
 * Created by georgezsiga on 4/14/17.
 */
public class App {
  public static void main(String[] args) {

    JFrame frame = new JFrame("PacMan George style");
    Area area = new Area();
    frame.add(area);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
    frame.addKeyListener(area);
  }
}
