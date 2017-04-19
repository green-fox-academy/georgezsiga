
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by georgezsiga on 4/19/17.
 */
public class SortTheArray {
  public static <T extends Number> void sortArray( T[] inputArray ) {
    Arrays.sort(inputArray, Collections.reverseOrder());
    for (int i = 0; i < inputArray.length; i++)
      System.out.println(inputArray[i]);
  }

  public static void main(String[] args) {
    Integer[] array = {2, 3, 5, 1};
   sortArray(array);
  }

}
