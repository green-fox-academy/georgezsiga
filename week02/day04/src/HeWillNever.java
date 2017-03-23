import java.util.*;
import java.util.stream.Stream;

/**
 * Created by georgezsiga on 3/23/17.
 */


public class HeWillNever {
  public static void main(String... args) {

    int[] notSoCrypticMessage = new int[]{1, 12, 1, 2, 11, 1, 7, 11, 1, 49, 1, 3, 11, 1, 50, 11};

    HashMap<String, String> hmap = new HashMap<String, String>();

    hmap.put("7", "run around and desert you");
    hmap.put("50", "tell a lie and hurt you");
    hmap.put("49", "make you cry,");
    hmap.put("2", "let you down");
    hmap.put("12", "give you up,");
    hmap.put("1", "Never gonna");
    hmap.put("11", "\n");
    hmap.put("3", "say goodbye");

    System.out.println("After Sorting:");
    Set set2 = hmap.entrySet();
    Iterator iterator2 = set2.iterator();
    while (iterator2.hasNext()) {
      Map.Entry me2 = (Map.Entry) iterator2.next();
//      System.out.print(me2.getKey() + ": ");
//      System.out.println(me2.getValue());
      String out = me2;

//    Stream sorted = hmap.entrySet().stream().sorted(Map.Entry.comparingByValue());
//      hmap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::print);
//    System.out.println(sorted);
//    ((notSoCrypticMessage) hmap)

      // Things are a little bit messed up
      // Your job is to decode the notSoCrypticMessage by using the hashmap as a look up table
      // Assemble the fragments into the out variable

      System.out.println(out);
    }
  }
}
