/**
 * Created by georgezsiga on 4/3/17.
 */
public class Station {

  int gasAmount;

  public void refill(Car name) {
    if (gasAmount > (name.capacity - name.gasAmount)) {
    this.gasAmount = gasAmount - (name.capacity - name.gasAmount);
    name.gasAmount = name.gasAmount + (name.capacity - name.gasAmount);
    }
    System.out.println("Sorry, out of gas");
  }

  public static void main(String[] args) {
    Car cadillac = new Car("Cadillac");

    Station station = new Station();
    station.gasAmount = 40;
    station.refill(cadillac);
    System.out.println(cadillac.gasAmount);
    System.out.println(station.gasAmount);
  }
}
