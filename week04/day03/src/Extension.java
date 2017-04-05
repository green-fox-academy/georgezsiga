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
    if (a > b && a > c) {
      return a;
    } else if (b > a && b > c ){
      return b;
    } else {
      return c;
    }
  }

  double median(List<Integer> pool) {
    Collections.sort(pool);

    if (pool.size() % 2 != 0) {
      int median;
      median = pool.get((pool.size()-1) / 2);
      return (double) median;
    } else {
      int a = pool.size();
      int median;
      median = (pool.get((a - 1) / 2) + pool.get((a + 1) / 2))/2;
      return (double) median;
    }
  }

  boolean isVowel(char c) {
    return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
  }

  String translate(String hungarian) {
    String teve = hungarian;
    int length = teve.length();
    if (length == 1) {
      char c = teve.charAt(0);
      if (isVowel(c)) {
        teve = String.join(c + "v" + c);
        return teve;
      } else {
        return teve;
      }
    } else {
      for (int i = 0; i < length; i++) {
        char c = teve.charAt(i);
        if (isVowel(c)) {
          teve = String.join(c + "v" + c, teve.split("" + c));
          i += 2;
          length += 2;
        }
      }

    }
    return teve;
  }
}