/**
 * Created by georgezsiga on 4/3/17.
 */
public class Animal {

  int hunger;
  int thirst;
  String name;

  @Override
  public String toString() {
    return name +
        ": hunger=" + hunger +
        ", thirst=" + thirst;
  }

  public Animal(String name) {
    hunger = 50;
    thirst = 50;
    this.name = name;
  }

  public void eat() {
    hunger -= 1;
  }

  public void drink() {
    thirst -= 1;
  }

  public void play() {
    hunger += 1;
    thirst -= 1;
  }

  public static void main(String[] args) {
    Animal lion = new Animal("Lion");
    System.out.println(lion.toString());

  }
}
