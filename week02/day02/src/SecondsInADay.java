/**
 * Created by georgezsiga on 3/21/17.
 */
public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        // Write a program that prints the remaining seconds (as an integer) from a
        // day if the current time is represented bt the variables ex 11

        int remainingSeconds = (((23 - currentHours) * 60) + (59 - currentMinutes)) * 60 + (60 - currentSeconds);
        System.out.println("You have " + remainingSeconds + " seconds left till midnight");
    }
}
