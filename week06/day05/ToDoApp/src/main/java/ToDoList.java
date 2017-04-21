import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/21/17.
 */
public class ToDoList {

  private ArrayList<ToDo> toDoList;

  public ToDoList() {
    this.toDoList = new ArrayList<>();
  }

  public ArrayList<ToDo> getToDoList() {
    return toDoList;
  }

  public void addToDo(String toDo) {
    ToDo newToDo = new ToDo(toDo);
    toDoList.add(newToDo);
  }

  public void soutList() {
    for (ToDo toDoItem : toDoList) {
      System.out.println(toDoItem.toFile());
    }
  }

  public void removeToDo(int number) {
    int startListLength = toDoList.size();
    for (ToDo toDoItem : toDoList) {
      if (toDoItem.getId() == number) {
        toDoList.remove(toDoItem);
      }
    }
    int finishListLength = toDoList.size();
    if (startListLength == finishListLength) {
      System.out.println("There is no ToDo with that ID number");
    }
  }

  public void completeToDo(int number) {
    for (ToDo toDoItem : toDoList) {
      if (toDoItem.getId() == number) {
        toDoItem.setCompletedAt(LocalDate.now());
      }
    }
  }

  public void readFromFile() {
    try {
      CSVReader reader = new CSVReader(new FileReader("src/main/resources/todolist.csv"), ';');
      String[] nextLine;
      while ((nextLine = reader.readNext()) != null) {
        String toDoFromFile = nextLine[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateCreatedFromFile = LocalDate.parse(nextLine[2], formatter);
        LocalDate dateFinishedFromFile = LocalDate.parse(nextLine[3], formatter);
        ToDo toDoItem = new ToDo(toDoFromFile, dateCreatedFromFile, dateFinishedFromFile);
        toDoList.add(toDoItem);
      }
    } catch (Exception e) {
      System.out.println("Houston we have a problem");

    }
  }

  public void printToFile(ArrayList<ToDo> toDoList) {
    ArrayList<String> list = new ArrayList<>();
    for (ToDo item : toDoList) {
      String line = item.toFile();
      list.add(line);
      try {
        Path filePath = Paths.get("src/main/resources/todolist.csv");
        Files.write(filePath, list);
      } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Uh-oh, could not write the file!");
      }
    }
  }
}
