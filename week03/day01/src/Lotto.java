import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by georgezsiga on 3/27/17.
 */
public class Lotto {
  public static void main(String[] args) {
    // Create a method that find the 5 most common lotto numbers assets/lotto.csv
    try {
      // Reads the content from `lorem_ipsum.txt` in the `assets` folder line by line to a String List
      Path filePath = Paths.get("assets/otos.csv");
      List<String> lines = Files.readAllLines(filePath);

      ArrayList aList = new ArrayList(Arrays.asList(lines.toString().split("[;,]")));

//      System.out.println(aList.get(15));

      for (int i = 11; i < aList.size(); i = i+16) {
ArrayList numbers =
//          System.out.println(aList.get(i));
        }


    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
    }
  }

