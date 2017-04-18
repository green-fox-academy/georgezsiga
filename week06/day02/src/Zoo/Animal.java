package Zoo;

/**
 * Created by georgezsiga on 4/18/17.
 */
public abstract class Animal {

  int age;
  String name, gender;

  public Animal(String name) {
    this.name = name;
  }

  public abstract void greet();

  public abstract String wantChild();

  public abstract void eat();

  public abstract void drink();

  public abstract void sleep();

  public abstract void move();

  public String getName() {
    return name;
  }
}
