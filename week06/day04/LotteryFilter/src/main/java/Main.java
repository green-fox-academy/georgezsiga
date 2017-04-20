import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * Created by georgezsiga on 4/20/17.
 */
public class Main {

  public List<String[]> readFile(String fileName) {
    try {
      CSVReader reader = new CSVReader(new FileReader(fileName), ';');
      return reader.readAll();
    }
    catch (Exception e) {
      System.out.println("Problem");
      return null;
    }
  }

  public void writeFile(String fileName, List<String[]> lines) {
    try {
      CSVWriter writer = new CSVWriter(new FileWriter(fileName), ';', CSVWriter.NO_QUOTE_CHARACTER);
      writer.writeAll(lines);
      writer.close();
    }
    catch (Exception e) {
      System.out.println("Problem");
    }
  }

  public static void main(String[] args) {
    Main main = new Main();
    OptionParser parser = new OptionParser();
    parser.accepts("l");
    parser.accepts("y").withRequiredArg();
    parser.accepts("f").withRequiredArg();
    parser.accepts("o").withRequiredArg();
    OptionSet options = parser.parse(args);

    if (options.has("f") && options.has("y")) {
      String filename = options.valueOf("f").toString();
      String year = options.valueOf( "y").toString();
      List<String[]> list = main.readFile(filename);
      for (int i = 0; i < list.size(); i++) {
        String line = Arrays.toString(list.get(0));
        if (line.contains(year)) {
          list.remove(list.get(0));
        } else {

        }
      }
      main.writeFile("output.csv", list);
    }

    if (options.has("l")) {
      System.out.println("`-l` was given with the no additional information.");
    }
  }
}