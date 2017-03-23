import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by georgezsiga on 3/23/17.
 */
public class HomeWorkExcercise {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Object> object2 = new ArrayList<>();

    ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
    ArrayList<Object> listObject = new ArrayList<>(Arrays.asList(1, "dfsdfsd",3));

    list1.add(2, 4);
    list1.set(2, 5);
    System.out.println(list1.size() + "the size of the arraylist");
    System.out.println(list1.get(0) + "the first in the arraylist");
    System.out.println(list1);

    String stringlist = list1.toString();
    System.out.println("my stirnglist" + stringlist);

    String sentence = "first part second part";
    String firstPart  = sentence.substring(0, 10);
    String secondPart  = sentence.substring(11);
    System.out.println(firstPart);
    System.out.println(secondPart);

    String replacedString = sentence.replace('f', 'e');
    System.out.println(replacedString);

    System.out.println(sentence.charAt(0));

    String s1 = "aa";
    String s2 = "aa";

    if (s1 == s2) {
      System.out.println("yay");
    } else {
      System.out.println("noooooo");
    }
    s1 += "b";
//    s2 += "b";

//    if (s1.equals() == s2.equals()) {   // use.equals with strins and with not primitive types variables
//      System.out.println("yay");
//    } else {
//      System.out.println("noooooo");
//    }
//

    int comparedValue = s1.compareTo(s2);

    String[] words = sentence.split( " ");
    for (String word : words) {
      System.out.println(word);
    }

//    HashMap - new type of data structure , better than arraylists

    HashMap<String, Integer[]> classExamResults = new HashMap<>();
    Integer[] norbisResutls = {5,5,5};
    Integer[] dorisResutls = {5,2,5};
    classExamResults.put("Norbi", norbisResutls);
    classExamResults.put("Dori", dorisResutls);
    System.out.println(Arrays.toString(classExamResults.get("Norbi")));


//    Object[] sampleArray = (Object[]) list1.toArray(listObject);
  }

}
