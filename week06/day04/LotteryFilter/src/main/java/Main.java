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
    parser.accepts("y").withRequiredArg();
    parser.accepts("f").withRequiredArg();
    parser.accepts("o").withRequiredArg();
    OptionSet options = parser.parse(args);

    if (!options.has("y")) {
      System.out.println("I need a year");
    } else {
      String year = options.valueOf("y").toString();
      String sourceFile =
          options.has("f") ? options.valueOf("f").toString() : "src/main/resources/otos.csv";
      String outputFile =
          options.has("o") ? options.valueOf("o").toString() : "src/main/resources/output.csv";
      List<String[]> list = main.readFile(sourceFile);
      List<String[]> updatedList = new ArrayList<>();
      for (String[] line : list) {
        if (Arrays.toString(line).contains(year + ".")) {
          updatedList.add(line);
        } else {

        }
      }
      main.writeFile(outputFile, updatedList);
    }
  }
}