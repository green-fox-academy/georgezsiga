package date;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/**
 * Created by georgezsiga on 4/20/17.
 */
public class BirthdayCalculatorWithLocalDate implements BirthdayCalculator<LocalDate> {

  @Override
  public String printMonthAndDay(T date) {
    return null;
  }

  @Override
  public boolean isAnniversaryToday(T date) {
    return false;
  }

  @Override
  public int calculateAgeInYears(T birthday) {

    return 0;
  }

  @Override
  public int calculateDaysToNextAnniversary(T date) {
    return 0;
  }
  @Override
  public LocalDate parseDate(String str) {
    return LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

  @Override
  public String printMonthAndDay(LocalDate date) {
    int day = date.getDayOfMonth();
    int month = date.getMonth().getValue();
    String today = month + ". " + day + ".";
    return today;
  }

  @Override
  public boolean isAnniversaryToday(LocalDate date) {
    int monthBirthday = date.getMonthValue();
    int dayBirthday = date.getDayOfMonth();
    if (monthBirthday == LocalDate.now().getMonthValue() && dayBirthday == LocalDate.now().getDayOfMonth()) {
      return true;
    }
    return false;
  }

  @Override
  public int calculateAgeInYears(LocalDate birthday) {
    int yearsBirthday = birthday.getYear();
    int yearsOfToday = LocalDate.now().getYear();
    return yearsOfToday - yearsBirthday;
  }

  @Override
  public int calculateDaysToNextAnniversary(LocalDate date) {
    int months = LocalDate.now().getMonthValue() - date.getMonthValue();
    // TODO - the number of days remaining to the next anniversary of 'date' (e.g. if tomorrow, return 1)
    return months;
  }

  public static void main(String[] args) {
    new BirthdayCalculatorWithLocalDate().run();
  }

  private void run() {

    print("Birthday with java.util.Date.");
    String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

    LocalDate birthdayDate = parseDate(birthdayStr);
    print("Your birthday: " + printMonthAndDay(birthdayDate));

    if (isAnniversaryToday(birthdayDate)) {
      int ageInYears = calculateAgeInYears(birthdayDate);
      print("Congratulations! Today is your " + ageInYears + "th birthday!");
    } else {
      int daysLeft = calculateDaysToNextAnniversary(birthdayDate);
      print("You have to wait only " + daysLeft + " days for your next birthday.");
    }
  }

  private void print(String line) {
    System.out.println(line);
  }

  private String readInput(String message) {
    System.out.print(message + ": ");
    return input.nextLine();
  }

  private final Scanner input = new Scanner(System.in, "UTF-8");
}
