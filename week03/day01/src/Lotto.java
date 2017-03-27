import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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

      ArrayList numbers = new ArrayList();  // get the winning numbers
      for (int i = 11; i < aList.size(); i = i + 16) {
        numbers.add(aList.get(i));
      }
      for (int j = 12; j < aList.size(); j = j + 16) {
        numbers.add(aList.get(j));
      }
      for (int k = 13; k < aList.size(); k = k + 16) {
        numbers.add(aList.get(k));
      }
      for (int m = 14; m < aList.size(); m = m + 16) {
        numbers.add(aList.get(m));
      }
      for (int n = 15; n < aList.size(); n = n + 16) {
        numbers.add(aList.get(n));
      }
      Collections.sort(numbers); // sort the winning numbers

//      System.out.println(numbers.get(2));
//      System.out.println(numbers);

      int maxCount = 0;
      Object number = 0;
      for (int x = 0; x < numbers.size(); x++) {
        Object tempNumber = numbers.get(x);
        int tempCount = 0;
        for (int z = 0; z < numbers.size(); z++)
          if (numbers.get(z).equals(tempNumber)) {
            tempCount = tempCount + 1;
          }
        if (tempCount > maxCount) {
          number = tempNumber;
          maxCount = tempCount;
        }
      }
      System.out.println(number + " " + maxCount);

      int maxCount2 = 0;
      Object number2 = 0;
      for (int x = 0; x < numbers.size(); x++) {
        Object tempNumber2 = numbers.get(x);
        int tempCount2 = 0;
        for (int z = 0; z < numbers.size(); z++)
          if (numbers.get(z).equals(tempNumber2)) {
            tempCount2 = tempCount2 + 1;
          }
        if (tempCount2 > maxCount2 && tempCount2 != maxCount) {
          number2 = tempNumber2;
          maxCount2 = tempCount2;
        }
      }
      System.out.println(number2 + " " + maxCount2);

      int maxCount3 = 0;
      Object number3 = 0;
      for (int x = 0; x < numbers.size(); x++) {
        Object tempNumber3 = numbers.get(x);
        int tempCount3 = 0;
        for (int z = 0; z < numbers.size(); z++)
          if (numbers.get(z).equals(tempNumber3)) {
            tempCount3 = tempCount3 + 1;
          }
        if (tempCount3 > maxCount3 && tempCount3 != maxCount && tempCount3 !=maxCount2) {
          number3 = tempNumber3;
          maxCount3 = tempCount3;
        }
      }
      System.out.println(number3 + " " + maxCount3);

      int maxCount4 = 0;
      Object number4 = 0;
      for (int x = 0; x < numbers.size(); x++) {
        Object tempNumber4 = numbers.get(x);
        int tempCount4 = 0;
        for (int z = 0; z < numbers.size(); z++)
          if (numbers.get(z).equals(tempNumber4)) {
            tempCount4 = tempCount4 + 1;
          }
        if (tempCount4 > maxCount4 && tempCount4 != maxCount && tempCount4 != maxCount2 && tempCount4 != maxCount3) {
          number4 = tempNumber4;
          maxCount4 = tempCount4;
        }
      }
      System.out.println(number4 + " " + maxCount4);

      int maxCount5 = 0;
      Object number5 = 0;
      for (int x = 0; x < numbers.size(); x++) {
        Object tempNumber5 = numbers.get(x);
        int tempCount5 = 0;
        for (int z = 0; z < numbers.size(); z++)
          if (numbers.get(z).equals(tempNumber5)) {
            tempCount5 = tempCount5 + 1;
          }
        if (tempCount5 > maxCount5 && tempCount5 != maxCount && tempCount5 != maxCount2 && tempCount5 != maxCount3 && tempCount5 != maxCount4) {
          number5 = tempNumber5;
          maxCount5 = tempCount5;
        }
      }
      System.out.println(number5 + " " + maxCount5);


      // the catch element...

    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }
}

