import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by georgezsiga on 3/27/17.
 */
public class Doubled {

  public static void main(String[] args) {
    // Create a method that decrypts the assets/duplicated_chars.txt

    try {
      // Reads the content from `lorem_ipsum.txt` in the `assets` folder line by line to a String List
      Path filePath = Paths.get("assets/duplicated-chars.txt");
      List<String> lines = Files.readAllLines(filePath);
      ArrayList aList = new ArrayList(Arrays.asList(lines.toString().split("(?!^)")));
      String decryptedLetter = new String();
      Object text = "";
      for (int i = 0; i < aList.size(); i++) {
        text = aList.get(i);
        decryptedLetter = decryptedLetter + text;
        aList.remove(text);
      }
      System.out.println(decryptedLetter);
    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }
}
