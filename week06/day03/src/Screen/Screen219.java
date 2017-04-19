package Screen;

/**
 * Created by georgezsiga on 4/19/17.
 */
@Monitor
public class Screen219 extends Screen {

  public Screen219(int width, int height, int resolution, ScreenSize screenSize) {
    super(width, height, resolution, screenSize);
  }

  @Override
  public String toString() {
    return "Screen219 - " +
        "width=" + width +
        ", height=" + height +
        ", resolution=" + resolution +
        ", size=" + size +
        ", classification=" + classification +
        ", aspectratio=" + aspectRatio;
  }
}
