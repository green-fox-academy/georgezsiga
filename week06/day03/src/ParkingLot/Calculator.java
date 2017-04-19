package ParkingLot;

/**
 * Created by georgezsiga on 4/19/17.
 */
public class Calculator {

  public static <T extends Number> int addNumbers(T x, T y) {
    return x.intValue() + y.intValue();
  }

  public static <T extends Number> int substractNumbers(T x, T y) {
    return x.intValue() - y.intValue();
  }

  public static <T extends Number> int multipleNumbers(T x, T y) {
    return x.intValue() * y.intValue();
  }

  public static <T extends Number> double divideNumbers(T x, T y) {
    try {
      return x.doubleValue() / y.doubleValue();
    }
    catch (ArithmeticException e) {
      System.out.println("Cant divide by 0");
    }
    return 0;
  }


}
