import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by georgezsiga on 3/28/17.
 */
public class ReversedOrder {
  public static void main(String[] args) {
    // Create a method that decrypts assets/reversed_zen_order.txt
    try {
      // Reads the content from `lorem_ipsum.txt` in the `assets` folder line by line to a String List
      Path filePath = Paths.get("assets/reversed-order.txt");
      List<String> lines = Files.readAllLines(filePath);
      for (int j = lines.size(); j > 0; j--) {
        System.out.println(lines.get(j));
      }
    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }
}

