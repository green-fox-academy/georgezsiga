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
      ArrayList numbers = new ArrayList();
      for (int i = 11; i < aList.size(); i = i+16) {
        numbers.add(aList.get(i));
        }
      for (int j = 12; j < aList.size(); j = j+16) {
        numbers.add(aList.get(j));
      }
      for (int k = 13; k < aList.size(); k = k+16) {
        numbers.add(aList.get(k));
      }
      for (int m = 14; m < aList.size(); m = m+16) {
        numbers.add(aList.get(m));
      }
      for (int n = 15; n < aList.size(); n = n+16) {
        numbers.add(aList.get(n));
      }
      System.out.println(numbers);

    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
    }
  }

