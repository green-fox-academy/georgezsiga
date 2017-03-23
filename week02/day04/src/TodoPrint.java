/**
 * Created by georgezsiga on 3/23/17.
 */
public class TodoPrint {
  public static void main(String... args){
    String todoText = " - Buy milk\n";
    // Add "My todo:" to the beginning of the todoText
    // Add " - Download games" to the end of the todoText
    // Add " - Diablo" to the end of the todoText but with indention

    // Expected outpt:

    // My todo:
    //  - Buy milk
    //  - Download games
    //      - Diablo
    String todo = "My todo:\n";
    String download = " - Download games\n";
    String diablo = "\t - Diablo";
    todo = todo.concat(todoText + download + diablo);

    System.out.println(todo);
  }
}
