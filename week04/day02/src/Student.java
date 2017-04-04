/**
 * Created by georgezsiga on 4/3/17.
 */
public class Student extends Person{
  String previousOrganization;
  int skippedDays;

  public void introduce() {
    System.out.println("Hi, I`m " + name + ", " + age + " years old " + gender + " from " + previousOrganization + " who skipped " + skippedDays + " days from the course already");
  }

  public void getGoal() {
    System.out.println("Be a junior software developer");
  }

  public void skipDays(int numberOfDays) {
    skippedDays = skippedDays + numberOfDays;
  }

  public Student(String name, int age, String gender, String previousOrganization) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  public Student() {
    this.name = "Jane Doe";
    this.age = 30;
    this.gender = "female";
    this.previousOrganization = "The School of Life";
    this.skippedDays = 0;
  }
}
