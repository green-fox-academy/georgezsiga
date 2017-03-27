import javax.swing.*;
/**
 * Created by georgezsiga on 3/27/17.
 */
public class bucky {
  public static void main(String[] args){

    JFrame f = new JFrame("Title");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    HomeworkExcercisePractice p = new HomeworkExcercisePractice();
    f.add(p);
    f.setSize(600,400);
    f.setVisible(true);

  }
}
