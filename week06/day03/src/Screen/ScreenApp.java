package Screen;

/**
 * Created by georgezsiga on 4/19/17.
 */
public class ScreenApp {

  public static void main(String[] args) throws Exception {
    Screen screen = new Screen169(10, 21, 300, ScreenSize.INCH15);
    System.out.println(screen.toString());
    screen = new Screen169(102, 212, 300, ScreenSize.INCH17);
    System.out.println(screen.toString());
    screen = new Screen169(160, 213, 300, ScreenSize.INCH19);
    System.out.println(screen.toString());
    screen = new Screen43(20, 214, 700, ScreenSize.INCH21);
    System.out.println(screen.toString());
    screen = new Screen43(360, 663, 900, ScreenSize.INCH23);
    System.out.println(screen.toString());
    screen = new Screen43(560, 443, 300, ScreenSize.INCH29);
    System.out.println(screen.toString());
    screen = new Screen219(860, 943, 700, ScreenSize.INCH34);
    System.out.println(screen.toString());
    screen = new Screen219(360, 143, 1200, ScreenSize.INCH25);
    System.out.println(screen.toString());
    screen = new Screen219(760, 503, 3000, ScreenSize.INCH23);
    System.out.println(screen.toString());
  }
}
