import java.util.*;

/**
 * Created by georgezsiga on 3/23/17.
 */
public class AppendLetter {
  public static void main(String... args) {
    ArrayList<String> far = new ArrayList<String>(Arrays.asList("kuty", "macsk", "kacs", "rók", "halacsk"));
    // Add "a" to every string in the far list.

    ArrayList<String> full = new ArrayList<String>(Arrays.asList());
    int length = far.size();
    for (int i = 0; i < length; i++) {
      full.add(far.get(i) + "a");
    }
    System.out.println(full);
  }
}
