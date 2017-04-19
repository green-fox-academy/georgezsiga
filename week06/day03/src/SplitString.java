import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/19/17.
 */
public class SplitString {

  public ArrayList<String> splitTheString(String string, int index) {
    ArrayList<String> splitStrings = new ArrayList<>();
    try {
      String firstString = string.substring(0, index);
      String secondString = string.substring(index, string.length());
      splitStrings.add(firstString);
      splitStrings.add(secondString);
    } catch (StringIndexOutOfBoundsException e) {
      System.out.println("Index is out of bounds");
    }
    return splitStrings;
  }

  public static void main(String[] args) {
    SplitString splitString = new SplitString();
    System.out.println(splitString.splitTheString("LoveBarbara", 4));
  }
}
