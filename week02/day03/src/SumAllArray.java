/**
 * Created by georgezsiga on 3/22/17.
 */
// - Create an array variable named `ai`
//   with the following content: `[3, 4, 5, 6, 7]`
// - Print the sum of the elements in `ai`

public class SumAllArray {
  public static void main(String[] args) {
    int[] ai = {3,4,5,6,7};
    int sum = 0;
    for (int i : ai) {
      sum += ai[i];
    }
    System.out.println(sum);
  }
}
