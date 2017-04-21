import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/21/17.
 */
public class ToDoList {

  private ArrayList<ToDo> toDoList;

  public ToDoList() {
  this.toDoList = new ArrayList<>();
  }

  public void addToDo(String toDo) {
    ToDo newToDo = new ToDo(toDo);
    toDoList.add(newToDo);
  }
}
