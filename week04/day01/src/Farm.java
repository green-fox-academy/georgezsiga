/**
 * Created by georgezsiga on 4/3/17.
 */
public class Farm {
  int slots;

  public void breed() {
    slots -=1;
  }

  public void slaughter() {
    slots +=1;
  }
}
