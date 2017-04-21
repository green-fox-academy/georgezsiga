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
    parser.accepts("u").withRequiredArg();
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
          System.out.println("You need to give an index to remove a task");
        }
      }
      if (options.has("c")) {
        if (options.hasArgument("c")) {
          int number = Integer.parseInt(options.valueOf("c").toString());
          list.completeToDo(number);
          list.soutList();
        } else {
          System.out.println("You need to give an index to finish a task");
        }
      }
      if (options.has("u")) {
        if (options.hasArgument("u")) {
          System.out.println("has argument u");
        } else {
          System.out.println("You need to give an index to update a task");
        }
      }
      list.printToFile(list.getToDoList());
    } catch (Exception e) {
      System.out.println("Huston we have a problem");
    }
  }
}




