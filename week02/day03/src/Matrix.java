/**
 * Created by georgezsiga on 3/22/17.
 */
// - Create (dynamically) a two dimensional array
//   with the following matrix. Use a loop!
//
//   1 0 0 0
//   0 1 0 0
//   0 0 1 0
//   0 0 0 1
//
// - Print this two dimensional array to the output

public class Matrix {
  public static void main(String[] args) {

    int[][] array = new int[4][4];

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (i == j) {
          array[i][j] = 1;
        }
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }

  }
}