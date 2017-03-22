import java.util.Arrays;

/**
 * Created by georgezsiga on 3/22/17.
 */
public class ExplainPracticeHomework {
  public static void main(String[] args) {

//    Arrays

    int[] numbers = {1,2,3,4,5};
    int[] numbers2 = {1,2,3,4,5};

    String[] classNames = {"Eagles","Sabers", "Zodiac"};

    int[] numbersCopy = Arrays.copyOf(numbers, 2);
    int[] copyNotFromTheBeginning = Arrays.copyOfRange(numbers, 3, 5);


    int[] numbersSumArray = new  int[numbers.length + numbers2.length];
    for(int i=0; i<numbers.length; i++) {
      numbersSumArray[i] = numbers[i];
      numbersSumArray[numbers.length + i] = numbers2[i];
    }

    for(int currentNumber : numbers) {
      System.out.println(currentNumber);
    }

    for(String currentClass : classNames) {
      currentClass = "Lagopus" + currentClass;
      System.out.println(currentClass);
    }

    Arrays.sort(numbersSumArray);

    for (int i=0; i<numbers.length; i++) {
      System.out.println(numbers[i]);
    }

    int searchPos = Arrays.binarySearch(numbersSumArray, 3);
    System.out.println("Search result: " + searchPos);

    System.out.println(numbers.length);
    System.out.println(Arrays.toString(numbersCopy));


    /* Functions */

    printNumbersFrom0to5();
    printNumbersTillInput(100);
    int sumValue = sumInputValues( 3, 4);
    System.out.println("SumV value:" + sumValue);

    int[] concatanatedArray = concatenateArrays(numbers, numbers2);
    System.out.println(Arrays.toString(concatanatedArray));


  }


  public static void printNumbersFrom0to5() {
    for(int i=0; i<6; i++) {
      System.out.println(i);
    }
  }

  public static void printNumbersTillInput(int maxValue) {
    for (int i = 9; i < maxValue + 1; i++) {
      System.out.println(i);
    }
  }
    public static int sumInputValues(int number1, int number2) {
    int sum = number1 + number2;
    return sum;
    }

    public static int[] concatenateArrays(int[] array1, int[] array2) {
      int[] concetaneteArray = new int[array1.length + array2.length];

      int position =0;
      for (int arrayData1: array1) {
        concetaneteArray[position] = arrayData1;
        position++;
      }

        for (int arrayData2: array2) {
          concetaneteArray[position] = arrayData2;
          position++;
      }
      return concetaneteArray;
  }
}
