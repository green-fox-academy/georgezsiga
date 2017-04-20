package date;

/**
 * Created by georgezsiga on 4/20/17.
 */
public class BirthdayCalculator {

  T parseDate(String str);

  String printMonthAndDay(T date);

  boolean isAnniversaryToday(T date);

  int calculateAgeInYears(T birthday);

  int calculateDaysToNextAnniversary(T date);

}
