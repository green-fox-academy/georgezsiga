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
//      List<String> letters = new List<String>(lines.subList(?<=\\G.{1}));

//      System.out.println(lines);
//      ArrayList<String> splitLines = new ArrayList<>(lines.spliterator(""));
      ArrayList aList = new ArrayList(Arrays.asList(lines.toString().split("(?!^)")));
      System.out.println(aList);

      String decryptedLetter = new String();
      int maxCount =2;
      String text = "";
      for (int i = 0; i < lines.size(); i++) {
        text = lines.get(i);
        decryptedLetter = decryptedLetter + text;
        int tempCount = 0;
        for (int j = 0; j < lines.size(); j++)
          if (lines.get(j).equals(text)) {
            tempCount = tempCount + 1;
          }
        if (tempCount == maxCount) {
          decryptedLetter = decryptedLetter + text;
          lines.remove(i);

    }
    }
      System.out.println(decryptedLetter);

    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }
}
