package Lagopus;

/**
 * Created by georgezsiga on 4/3/17.
 */
public class Sponsor extends Person {

  String company;
  int hiredStudents;

  public void introduce() {
    System.out.println("Hi, I`m " + name + ", a " + age + " years old " + gender + " who represents " + company + " and hired " + hiredStudents + " students so far.");
  }

  public void getGoal() {
    System.out.println("Hire brilliant junior sofware developers");
  }

  public void hire() {
    this.hiredStudents +=1;
  }

  public Sponsor(String name, int age, String gender, String company) {
    super(name, age, gender);
    this.company = company;
    this.hiredStudents = 0;
  }

  public Sponsor() {
    super();
    this.company = "Google";
    this.hiredStudents = 0;
  }
}
