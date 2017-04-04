package Lagopus;

/**
 * Created by georgezsiga on 4/3/17.
 */
public class Mentor extends Person {

  String level;

  public void introduce() {
    System.out.println("Hi, I`m " + name + ", a " + age + " years old " + gender + level + " mentor.");
  }

  public void getGoal() {
    System.out.println("Educate brilliant junior software developers");
  }

  public Mentor(String name, int age, String gender, String level) {
    super(name, age, gender);
    this.level = level;
  }

  public Mentor() {
    super();
    this.level = "intermediate";
  }
}
