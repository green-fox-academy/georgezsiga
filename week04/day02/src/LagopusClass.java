import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class LagopusClass extends Person {
  String className;
  List students;
  List mentors;

  public void addStudent(Student student) {
    this.students.add(student);
  }

  public void addStudent(Mentor mentor) {
    this.mentors.add(mentor);
  }

  public void info() {
    System.out.println("Lagopus " + className + " class has " + students.size() + " students and " + mentors.size() + " mentors.");
  }

  public LagopusClass(String className) {
    this.className = className;
    this.students = new ArrayList();
    this.mentors = new ArrayList();
  }
}
