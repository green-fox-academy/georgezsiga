import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by georgezsiga on 3/28/17.
 */
public class EncodedLines {
  public static void main(String[] args) {
    // Create a method that decrypts assets/encoded_zen_lines.txt
    try {
      // Reads the content from `lorem_ipsum.txt` in the `assets` folder line by line to a String List
      Path filePath = Paths.get("assets/lorem_ipsum.txt");
      List<String> lines = Files.readAllLines(filePath);
      ArrayList aList = new ArrayList(Arrays.asList(lines.toString().split("(?!^)")));
      ArrayList<String> ALPHABET = new ArrayList<>(Arrays.asList("!", "\"", "\'", "(", ")", "+", ",", "-", ".", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
      String decryptedLetter = new String();
      Object text = "";
      for (int i = 0; i < aList.size(); i++) {
        text = aList.get(i);
        int text2 = ALPHABET.indexOf(text) - 1;
        Object text3 = ALPHABET.get(text2);
        decryptedLetter = decryptedLetter + text3;
        aList.remove(text);
      }
      System.out.println(decryptedLetter);
    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }
}
