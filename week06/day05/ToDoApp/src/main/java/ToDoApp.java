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
    parser.accepts("r").withOptionalArg();
    parser.accepts("c").withOptionalArg();
    parser.accepts("u").withOptionalArg();
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
        } else {
          System.out.println("You need to give a New Task, in order to add a new task.. ");
        }
      }
      if (options.has("r")) {
        if (options.hasArgument("r")) {
          int number = Integer.parseInt(options.valueOf("r").toString());
          list.removeToDo(number);
          list.soutList();
        } else {
          System.out.println("You need to give an index to remove a task");
          System.out.println();
          list.soutList();
        }
      }
      if (options.has("c")) {
        if (options.hasArgument("c")) {
          int number = Integer.parseInt(options.valueOf("c").toString());
          list.completeToDo(number);
          list.soutList();
        } else {
          System.out.println("You need to give an index to finish a task");
          System.out.println();
          list.soutList();
        }
      }
      if (options.has("u")) {
        if (options.hasArgument("u")) {
          System.out.println("has argument u");
        } else {
          System.out.println("You need to give an index to update a task");
          System.out.println();
          list.soutList();
        }
      }
      list.printToFile(list.getToDoList());
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("Huston we have a problem");
    }
  }
}




