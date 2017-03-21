/**
 * Created by georgezsiga on 3/21/17.
 */
public class VariableMutations {
  public static void main(String[] args) {
    double a = 24;
    int out = 0;
    // if w a!!!!!!! is even increment out by one
    double even = (a % 2);
    if (even == 0) {
      out = (out + 1);
      System.out.println(out);
    }

    int b = 13;
    String out2 = "";
    // if b is between 10 and 20 set out2 to "Sweet!"
    // if less than 10 set out2 to "More!",
    // if more than 20 set out2 to "Less!"
    if ((b <= 20) && (b >= 10)) {
      out2 = "Sweet!";
      System.out.println(out2);
    } else {
      if (b < 10) {
        out2 = "More!";
        System.out.println(out2);
      } else {
        out2 = "Less!";
        System.out.println(out2);
      }
    }

    int c = 123;
    int credits = 100;
    boolean isBonus = false;
    // if credits are at least 50,
    // and isBonus is false decrement c by 2
    // if credits are smaller than 50,
    // and isBonus is false decrement c by 1
    // if isBonus is true c should remain the same
    if (isBonus) {
      System.out.println(c);
    } else {
      if ((credits >= 50) && (!isBonus)) {
        c = (c - 2);
        System.out.println(c);
      } else{
        if ((credits < 50) && (!isBonus)) {
          c = (c - 1);
          System.out.println(c);
        }
      }
    }


    int d = 8;
    int time = 120;
    String out3 = "";
    // if d is dividable by 4
    // and time is not more than 200
    // set out3 to "check"
    // if time is more than 200
    // set out3 to "Time out"
    // otherwise set out3 to "Run Forest Run!"
    int fourMin = (d % 4);

    if (time > 200) {
      out3 = "Time out!";
      System.out.println(out3);
    } else {
      if (fourMin == 0) {
        out3 = "check";
        System.out.println(out3);
      } else {
        out3 = "Run Forest Run!";
        System.out.println(out3);
      }
    }
  }
}

