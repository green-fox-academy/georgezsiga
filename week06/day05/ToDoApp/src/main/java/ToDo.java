import java.time.LocalDate;

/**
 * Created by georgezsiga on 4/21/17.
 */
public class ToDo extends ToDoList {
  private static int idCounter = 0;
  private int id;
  private String toDo;
  private LocalDate createdAt, completedAt;

  public ToDo(String toDo) {
    this.id = idCounter++;
    this.toDo = toDo;
    this.createdAt = LocalDate.now();
    this.completedAt = null;
  }

  public ToDo(int id, String toDo, LocalDate createdAt, LocalDate completedAt) {
    this.id = id;
    this.toDo = toDo;
    this.createdAt = createdAt;
    this.completedAt = completedAt;
  }

  public int getId() {
    return id;
  }

  public void setCompletedAt(LocalDate completedAt) {
    this.completedAt = completedAt;
  }

  public String toFile() {
    return id + ";" + toDo + ";" + createdAt + ";" + completedAt + ";";
  }

  @Override
  public String toString() {
    if (completedAt == null)
      return "id: " + id + ", toDo: " + toDo + ", ToDo created: " + createdAt + ", this task is not completed yet";
    return "id: " + id + ", toDo: " + toDo + ", ToDo created: " + createdAt + ", completed: " + completedAt;
  }

}
