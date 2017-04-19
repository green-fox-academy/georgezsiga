package Screen;

/**
 * Created by georgezsiga on 4/19/17.
 */
@Monitor
public class Screen {

  int width, height, resolution;
  ScreenSize size;

  public Screen(int width, int height, int resolution, ScreenSize screenSize) {
    this.size = screenSize;
    this.width = width;
    this.height = height;
    this.resolution = resolution;
  }
}
