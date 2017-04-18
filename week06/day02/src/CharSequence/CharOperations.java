package CharSequence;

/**
 * Created by georgezsiga on 4/18/17.
 */
public class CharOperations implements CharSequence{

  @Override
  public int length() {
    return 0;
  }

  @Override
  public char charAt(int i) {
    return 0;
  }

  @Override
  public CharSequence subSequence(int from, int till) {
    String input = "alma";
    String reversed = "";
    for (int i = till; i > from-1 ; i--) {
      reversed = reversed + input.charAt(i);
    }
    return reversed;
  }

  public static void main(String[] args) {
    CharOperations charOp = new CharOperations();
    System.out.println(charOp.subSequence(1,3));
  }
}
