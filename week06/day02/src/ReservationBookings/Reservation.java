package ReservationBookings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by georgezsiga on 4/18/17.
 */
public class Reservation implements Reservationy {

  final String formatForPlay ="Booking# %s for %s\n";
  String dow;
  String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  List<String> days = new ArrayList<>(Arrays.asList("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"));

  @Override
  public String getDowBooking() {
    for (int i = 0; i < 8 ; i++) {
      int nr = (int) (Math.random() * alphabet.length());
      dow = dow + alphabet.charAt(nr);
    }
    return dow;
  }

  @Override
  public String getCodeBooking() {
    int nr = (int) (Math.random() * days.size());
    String bookingDay = days.get(nr);
    return bookingDay;
  }
}
