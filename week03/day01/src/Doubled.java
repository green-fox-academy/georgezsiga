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
      ArrayList letter = new ArrayList(Arrays.asList(lines.toString()));


      ArrayList decryptedLetter = new ArrayList();
      int maxCount = 0;
      Object text = 0;
      for (int i = 0; i < letter.size(); i++) {
        Object tempText = letter.get(i);
        int tempCount = 0;
        for (int j = 0; j < letter.size(); j++)
          if (letter.get(j).equals(tempText)) {
            tempCount = tempCount + 1;
          }
        if (tempCount == maxCount) {
          decryptedLetter.add(text);
//          number = tempNumber;
//          maxCount = tempCount;
        }
      }
      System.out.println(decryptedLetter);
//      topNumbers.add(number);
//      numbers.removeAll(topNumbers);

    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }
}
