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
      return hunger;
    }
  }

  public int drink() {
    if (thirst > 0) {
      thirst -= 1;
      return thirst;
    } else {
      System.out.println("The " + name + " died of thirst");
      return thirst;
    }
  }

  public int[] play() {
    if (thirst > 0) {
      thirst -= 1;
      hunger += 1;
      int[]letsPlay = {thirst, hunger};
      return letsPlay;
    } else {
      System.out.println("The " + name + " died of thirst");
      thirst -= 1;
      int[]letsPlay = {thirst, hunger};
      return letsPlay;
    }
  }
}
