import java.time.LocalDate;

/**
 * Created by georgezsiga on 4/21/17.
 */
public class ToDoList {

  private static int idCounter = 0;
  private int id;
  private String toDo;
  private LocalDate createdAt, completedAt;

  public ToDoList(String toDo, LocalDate createdAt) {
    this.id = idCounter++;
    this.toDo = toDo;
    this.createdAt = createdAt;
    this.completedAt = null;
  }

  @Override
  public String toString() {
    if (completedAt == null)
      return "id: " + id + ", toDo: " + toDo + ", ToDo created: " + createdAt + ", this task is not completed yet";
    return "id: " + id + ", toDo: " + toDo + ", ToDo created: " + createdAt + ", completed: " + completedAt;
  }
}
