import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * Created by georgezsiga on 4/21/17.
 */
public class ToDoApp {

  public static void main(String[] args) {
    ToDoList list = new ToDoList();
    OptionParser parser = new OptionParser();
    parser.accepts("l").withOptionalArg();
    parser.accepts("a").withOptionalArg();
    parser.accepts("r").withRequiredArg();
    parser.accepts("c").withRequiredArg();
    OptionSet options = parser.parse(args);
    list.readFromFile();

    try {
      if (options.has("l")) {
        if (options.hasArgument("l")) {
          System.out.println("has argument l");
        } else {
          list.soutList();
        }
      }
      if (options.has("a")) {
        if (options.hasArgument("a")) {
          list.addToDo(options.valueOf("a").toString());
          list.soutList();
          System.out.println("has argument a");
        } else {
          System.out.println("a");
        }
      }
      if (options.has("r")) {
        if (options.hasArgument("r")) {
          System.out.println("has argument r");
        } else {
          System.out.println("r");
        }
      }
      if (options.has("c")) {
        if (options.hasArgument("c")) {
          System.out.println("has argument c");
        } else {
          System.out.println("c");
        }
      }
      list.printToFile(list.getToDoList());
    } catch (Exception e) {
      System.out.println("Huston we have a problem");
    }
  }
}




