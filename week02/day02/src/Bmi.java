/**
 * Created by georgezsiga on 3/21/17.
 */
public class Bmi {
    public static void main(String[] args) {
        double massInKg = 80.4;
        double heightInM = 1.81;

        // Print the Body mass index (BMI) based on these values
        double bmi = ( massInKg / ( heightInM * heightInM ));
        System.out.println("My body mass index \"BMI\" is: " + bmi);
    }
}
