import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgezsiga on 4/3/17.
 */
public class SharpieSet {
  List<String> sharpies;
  public boolean countUsable;

  public void countUsable() {
      this.countUsable = true;
    }

  public void removeTrash() {

  }

  public static void main(String[] args) {
    List<Sharpie> sharpies = initializeSharpies();

    System.out.println(sharpies);
  }

  static List<Sharpie> initializeSharpies() {
    List<Sharpie> sharpies = new ArrayList<>();
    sharpies.add(new Sharpie("blue", 2));
    sharpies.add(new Sharpie("red", 6));
    sharpies.add(new Sharpie("green", 5));
    sharpies.add(new Sharpie("black", 7));
    return sharpies;
  }
}
