package Zoo;

/**
 * Created by georgezsiga on 4/18/17.
 */
public class Bird extends Animal {

  int numberOfEggs;
  String featherColor, peakColor;

  public Bird(String name) {
    super(name);
    wantChild();
  }

  @Override
  public void greet() {

  }

  @Override
  public String wantChild() {
    return "I want a child from an egg";
  }

  @Override
  public void eat() {

  }

  @Override
  public void drink() {

  }

  @Override
  public void sleep() {

  }

  @Override
  public void move() {

  }
}
