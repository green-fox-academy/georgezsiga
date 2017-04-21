import java.time.LocalDate;
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

  public void removeToDo(int number) {
    int startListLength = toDoList.size();
    for (ToDo toDoItem: toDoList) {
      if (toDoItem.getId() == number)
        toDoList.remove(toDoItem);
    }
    int finishListLength = toDoList.size();
    if (startListLength == finishListLength) {
      System.out.println("There is no ToDo with that ID number");
    }
  }

  public void completeToDo(int number) {
    for (ToDo toDoItem: toDoList) {
      if (toDoItem.getId() == number)
        toDoItem.setCompletedAt(LocalDate.now());
    }
  }
}
