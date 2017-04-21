import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Object;

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

//  public void addFromFile() {
//    List<String[]> listFromFile = readFile();
//    for (String[] line : listFromFile) {
////      String lineString = line.toString();
//      ToDo newItem = new ToDo(line.toString());
//      toDoList.add(newItem);
//    }
//  }

  public void soutList() {
    for (ToDo toDoItem : toDoList) {
      System.out.println(toDoItem);
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
      System.out.println(e);

    }
  }

  public void writeFile(List<String[]> lines) {
    try {
      CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/todolist.csv"), ';',
          CSVWriter.NO_QUOTE_CHARACTER);
      writer.writeAll(lines);
      writer.close();
    } catch (Exception e) {
      System.out.println("Problem");
    }
  }
}
