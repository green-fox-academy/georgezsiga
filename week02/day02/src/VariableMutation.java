/**
 * Created by georgezsiga on 3/21/17.
 */
public class VariableMutation {
  public static void main(String[] args) {
    int a = 3;
    // make it bigger by 10
    a = a + 10;

    System.out.println(a);

    int b = 100;
    // make it smaller by 7
    b = b - 7;

    System.out.println(b);

    int c = 44;
    // please double c's value
    c = (c * 2);

    System.out.println(c);

    int d = 125;
    // please divide by 5 d's value
    d = d / 5;

    System.out.println(d);

    int e = 8;
    // please cube of e's value
    e = (e * e * e);

    System.out.println(e);

    int f1 = 123;
    int f2 = 345;
    // tell if f1 is bigger than f2 (print as a boolean)
    boolean ab = (f1 > f2);
    System.out.println(ab);

    int g1 = 350;
    int g2 = 200;
    // tell if the double of g2 is bigger than g1 (print as a boolean)

    boolean g2b = ((2 * g2) > g1);
    System.out.println(g2b);

    long h = 1357988018575474L;
    // tell if it has 11 as a divisor (print as a boolean)
    long hh = (h % 11);
    if (hh == 0) {
      boolean divider = true;
      System.out.println(divider);
    }

    int i1 = 10;
    int i2 = 3;
    // tell if i1 is higher than i2 squared and smaller than i2 cubed (print as a boolean)
    int i3 = (i2 * i2);
    int i4 = (i2 * i2 * i2);

    if ((i1 > i3) && (i1 < i4)) {
      boolean higher = true;
      System.out.println(higher);
    }

    int j = 1521;
    // tell if j is dividable by 3 or 5 (print as a boolean)
    int j3 = (j % 3);
    int j5 = (j % 5);

    if ((j3 == 0) || (j5 == 0)) {
      boolean threeFive = true;
      System.out.println(threeFive);
    }


    String k = "Apple";
    //fill the k variable with its cotnent 4 times
    for (int l = 0; l < 4; l = l + 1) {
      System.out.println(k);
    }
  }
}
