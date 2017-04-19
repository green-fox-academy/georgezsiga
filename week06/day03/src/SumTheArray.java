/**
 * Created by georgezsiga on 4/19/17.
 */
public class SumTheArray {

  public static <T extends Number> int sumArray(T[] inputArray, int index) {
    int sum = 0;
    try {
      for (int i = 0; i < index; i++) {
        sum = sum + inputArray[i].intValue();
      }
      return sum;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Index is out of bounds");
      for (int i = 0; i < inputArray.length; i++) {
        System.out.print(inputArray[i] + ", ");
      }

    }
    return sum;
  }

  public static void main(String[] args) {
    Integer[] array = {2, 3, 5, 1};
    System.out.println(sumArray(array, 3));
  }

}
