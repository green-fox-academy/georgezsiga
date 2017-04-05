import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by georgezsiga on 4/5/17.
 */
public class Extension {

  int add(int a, int b) {
    return a + b;
  }

  int maxOfThree(int a, int b, int c) {
    if (a >= b && a >= c) {
      return a;
    } else if (b >= a && b >= c) {
      return b;
    } else {
      return c;
    }
  }

  double median(List<Integer> pool) {
    Collections.sort(pool);
    if (pool.size() % 2 == 1) {
      double median;
      median = pool.get(pool.size() / 2);
      return median;
    } else {
      double a = pool.get(pool.size() / 2) + 1;
      double b = pool.get((pool.size() - 1) / 2) - 1;
      double median;
      median = (a + b) / 2;
      return median;
    }
  }

  boolean isVowel(char c) {
    return Arrays.asList('a', 'u', 'o', 'e', 'i', 'ú', 'é', 'á', 'ő', 'ű', 'ö', 'ü', 'ó', 'í')
        .contains(c);
  }

  String translate(String hungarian) {
    String teve = hungarian;
    teve = teve.toLowerCase();
    int length = teve.length();
    if (teve.length() == 1) {
      char c = teve.charAt(0);
      if (isVowel(c)) {
        teve = c + "v" + c;
        return teve;
      } else {
        return teve;
      }
    } else {
      for (int i = 0; i < length; i++) {
        char c = teve.charAt(i);
        if (isVowel(c) && c == 0) {
          teve = c + "v" + teve;
          i += 2;
          length += 2;
        } else if (isVowel(c)) {
          String part1 = teve.substring(0, i);
          String part2 = teve.substring(i + 1);
          teve = part1 + c + "v" + c + part2;
          i += 2;
          length += 2;
        }
      }
      return teve;
    }
  }
}
