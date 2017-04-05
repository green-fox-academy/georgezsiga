/**
 * Created by georgezsiga on 4/5/17.
 */
public class Animal {

  int hunger;
  int thirst;
  String name;

  public Animal(String name) {
    hunger = 50;
    thirst = 50;
    this.name = name;
  }

  public int eat() {
    if (hunger > 0) {
      hunger -= 1;
      return hunger;
    } else {
      System.out.println("The " + name + " died of hunger");
      return 0;
    }
  }

  public void drink() {
    thirst -= 1;
  }

  public void play() {
    hunger += 1;
    thirst -= 1;
  }
}
