import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * Created by georgezsiga on 4/20/17.
 */
public class Main {

  public List<String[]> readFile() {
    try {
      CSVReader reader = new CSVReader(new FileReader("src/resources/otos.csv"), ';');
      List<String[]> lines = reader.readAll();
      return lines;
    } catch (Exception e) {
      System.out.println("Problem");
    }
    return null;
  }

  public void writeFile(List<String[]> lines) {
    try {
      CSVWriter writer = new CSVWriter(new FileWriter("src/resources/result.csv"), ';',
          CSVWriter.NO_QUOTE_CHARACTER);
      writer.writeAll(lines);
      writer.close();
    } catch (Exception e) {
      System.out.println("Problem");
    }
  }

  public static void main(String[] args) throws IOException {
    OptionParser parser = new OptionParser();
    parser.accepts("l");
    parser.accepts("a").withRequiredArg();
    parser.accepts("a").withRequiredArg();
    OptionSet options = parser.parse(args);

    if (options.has("a")) {
      System.out.println("`-a` was given with the argument " + options.valueOf("a"));
    }

    if (options.has("l")) {
      System.out.println("`-l` was given with the no additional information.");
    }


  }
}
