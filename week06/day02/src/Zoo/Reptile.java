package Zoo;

/**
 * Created by georgezsiga on 4/18/17.
 */
public class Reptile extends Animal {

  public Reptile(String name) {
    super(name);
    wantChild();
  }

  @Override
  public void greet() {

  }

  @Override
  public String wantChild() {
    return "want child from an egg";
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
