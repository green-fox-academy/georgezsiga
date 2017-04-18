package Zoo;

/**
 * Created by georgezsiga on 4/18/17.
 */
public class Mammal extends Animal {

  int numberOfBabies;

  public Mammal(String name) {
    super(name);
    wantChild();
  }


  @Override
  public void greet() {

  }

  @Override
  public String wantChild() {
    return "I want babies by mating";
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
