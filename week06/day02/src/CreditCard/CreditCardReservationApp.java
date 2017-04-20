package CreditCard;

import ReservationBookings.Reservation;

/**
 * Created by georgezsiga on 4/20/17.
 */
public class CreditCardReservationApp {

  public static void main(String[] args) {
    Reservation bookings = new Reservation();
    CreditCard card = new CreditCard("8752");
    System.out.println(bookings + " paid by " + card);
    card = new CreditCard("8752");
    System.out.println(bookings + " paid by " + card);
    card = new CreditCard("1234");
    System.out.println(bookings + " paid by " + card);
    card = new CreditCard("5346");
    System.out.println(bookings + " paid by " + card);
    card = new CreditCard("8712");
    System.out.println(bookings + " paid by " + card);
    card = new CreditCard("1256");
    System.out.println(bookings + " paid by " + card);
    card = new CreditCard("1874");
    System.out.println(bookings + " paid by " + card);
    card = new CreditCard("3426");
    System.out.println(bookings + " paid by " + card);
    card = new CreditCard("7634");
    System.out.println(bookings + " paid by " + card);
    card = new CreditCard("2452");
    System.out.println(bookings + " paid by " + card);

  }
}
