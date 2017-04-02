import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Created by georgezsiga on 3/25/17.
 */
 public class HomeworkExcerciseReview {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    File file = new File("Filereader.iml"); // read in a file
    file.isDirectory(); //is it a directory?
  }
}
/*

    System.out.println(file.exists());    // does the file exist?
    System.out.println(file.canRead() + file.canWrite());   // can we read the file, can we write the file?

    try {
      Scanner anotherScanner = new Scanner(File);
      while (anotherScanner.hasNext()) {
        System.out.println(anotherScanner.nextLine()); // scan the next line
      }
      scanner.close();
    } catch (IOException) { // start witht the most specific, exception, and go towards the most general
  }

    try {
      // Reads the content from `lorem_ipsum.txt` in the `assets` folder line by line to a String List
      Path filePath = Paths.get("assets/lorem_ipsum.txt");
      List<String> lines = Files.readAllLines(filePath);
    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }

  // this is the newer version...

    Path path = Paths.get("FileREader.iml");   //creating a new path.. dont have to specify a new File container -- this is a utility method.. lot of them can be stored there
    Files.isReadable(path);       // all files system interactions...
    Files.isWritable(path);       // checks if it is writeable
    Files.isDirectory(path);      // is it a Directory??
    Files.readAllLines(path);     // read all lines from the path
    try {
      List<String> lines = Files.readAllLines(path);   // read all lines from the path to lines
      for (String line : Files.readAllLines(path)) {    // for loop reads all the lines of the path..
        // for (String line : Files.readAllLines(Paths.get("FileReader.iml")));  - we can specify here the source too, dont need the line at the top
        System.out.println(line.toUpperCase());   // print it out all with upper case
      }

      Files.lines(Paths.get("FileReader.iml"))    // read the lines...
              .map(line -> line.toUpperCase())      // converting them to uppercase
              .filter(line -> line.startsWith(" ")) // filters out the onese that starts with a space
              .filter(line -> !line.startsWith(" ")) // filters out the ones that doesnt starts with a space
              .forEach(line -> System.out.println(line.toUpperCase())); // this is a for eachLoop to print the lines.

      Files.write(path, lines);         // write the lines from the path to the lines
      Files.lines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

}
*/