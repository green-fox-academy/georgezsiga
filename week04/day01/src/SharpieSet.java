import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgezsiga on 4/3/17.
 */
public class SharpieSet {

  public List<Sharpie> sharpies;

  public SharpieSet() {
    this.sharpies = new ArrayList<>();
  }

  public void add() {
    sharpies.add(new Sharpie("blue", 4));
    sharpies.add(new Sharpie("red", 6));
    sharpies.add(new Sharpie("green", 5));
    sharpies.add(new Sharpie("black", 7));
  }

  public int countUsable() {
    int count = 0;
    for (int i = 0; i < sharpies.size(); i++) {
      if (sharpies.get(i).inkAmount > 0) {
        count++;
      }
    }
    return count;
  }

  public void removeTrash() {
    for (int i = 0; i < sharpies.size(); ) {
      if (sharpies.get(i).inkAmount == 0) {
        sharpies.remove(i);
      } else {
        i++;
      }
    }
  }

  public static void main(String[] args) {
    SharpieSet sharpieSet = new SharpieSet();
    sharpieSet.add();
    sharpieSet.countUsable();
    sharpieSet.removeTrash();
    System.out.println(sharpieSet.sharpies);
  }
}
