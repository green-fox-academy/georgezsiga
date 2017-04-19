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
    if (y.doubleValue() == 0) {
  System.out.println("Cant divide by 0");
System.exit(0);
return 0;
    } else {
      return x.doubleValue() / y.doubleValue();
    }
  }

  public static void main(String[] args) {
    System.out.println(addNumbers(5,4));
    System.out.println(substractNumbers(5,4));
    System.out.println(multipleNumbers(5,4));
    System.out.println(divideNumbers(5,0));
  }
}
