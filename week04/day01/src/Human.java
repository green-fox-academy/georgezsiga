/**
 * Created by georgezsiga on 4/2/17.
 */
public class Human {

  String name;
  int age;
  int heightInCms;
  String eyeColor;
  int id;
  static int counter = 0;     // belongs to the class, not the object because of the static

  public Human() {

  }
  public Human(String name) {
    this.name = name;
    counter++;
    id = counter++;             // have the number when created...
  }
  void putInLenses() {
    eyeColor = "purple";
  }
  void putInLenses(String color) {
    eyeColor = color;
  }
  void putInLenses(int number) {

  }

  void baptism(String name) {
    this.name = name;
  }

  public void speak() {
    System.out.println("Hello my name is " + name);
    System.out.println("I am " + heightInCms + " cm tall");
    System.out.println("I am " + age + " years old");
    System.out.println("My eye colour is " + eyeColor);
  }

  public void eat() {
    System.out.println("eating...");
  }

  public void walk() {
    System.out.println("walking...");
  }

  public void work() {
    System.out.println("working...");
  }
}
