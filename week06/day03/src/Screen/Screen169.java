package Screen;

/**
 * Created by georgezsiga on 4/19/17.
 */
@Monitor(aspectRatio = "16:9", classification = "LCD")
public class Screen169 extends Screen {

  public Screen169(int width, int height, int resolution, ScreenSize screenSize) {
    super(width, height, resolution, screenSize);
  }

  Monitor annotation = Screen169.class.getAnnotation(Monitor.class);
  String aspectRatio = annotation.aspectRatio();
  String classification = annotation.classification();

  @Override
  public String toString() {
    return "Screen169 - " +
        "width=" + width +
        ", height=" + height +
        ", resolution=" + resolution +
        ", size=" + size +
        ", classification=" + classification +
        ", aspectratio=" + aspectRatio;
  }
}
