import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by georgezsiga on 3/27/17.
 */
public class ReversedLines {
  public static void main(String[] args) {
    // Create a method that decrypts assets/reversed_zen_lines.txt

    try {
      // Reads the content from `lorem_ipsum.txt` in the `assets` folder line by line to a String List
      Path filePath = Paths.get("assets/reversed-lines.txt");
      List<String> lines = Files.readAllLines(filePath);

      for (int j = 0; j < lines.size(); j++) {
        String stringLines = lines.get(j);
        for (int i = stringLines.length() - 1; i >= 0; i--) {
          System.out.print(stringLines.charAt(i));
        }
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }
}
