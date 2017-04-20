package date;


import java.time.LocalDate;

/**
 * Created by georgezsiga on 4/20/17.
 */
public interface BirthdayCalculator<L> {

  LocalDate parseDate(String str);

  String printMonthAndDay(T date);

  boolean isAnniversaryToday(T date);

  int calculateAgeInYears(T birthday);

  int calculateDaysToNextAnniversary(T date);

  String printMonthAndDay(LocalDate date);

  boolean isAnniversaryToday(LocalDate date);

  int calculateAgeInYears(LocalDate birthday);

  int calculateDaysToNextAnniversary(LocalDate date);
}
