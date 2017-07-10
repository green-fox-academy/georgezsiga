import static java.util.Arrays.asList;
import java.util.List;

/**
 * Created by georgezsiga on 7/10/17.
 */
public class Main {

  String space = " ";
  List<String> listOfStrings = asList("ab", "cde", "fg");

  public static String ConnectStrings(List listOfStrings, String space) {
    String connectedString = "";
    for (int i = 0; i < listOfStrings.size(); i++) {
      if (i < listOfStrings.size() - 1) {
        connectedString = connectedString + listOfStrings.get(i) + space;
      } else {
        connectedString = connectedString + listOfStrings.get(i);
      }
    }
    return connectedString;
  }

}
