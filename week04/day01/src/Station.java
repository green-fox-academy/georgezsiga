/**
 * Created by georgezsiga on 4/3/17.
 */
public class Station {

  int gasAmount;

  public void refill(Car name) {
    this.gasAmount = gasAmount - (name.capacity - name.gasAmount);
    name.gasAmount = name.gasAmount + (name.capacity - name.gasAmount);
  }

  public static void main(String[] args) {
    Car cadillac = new Car("Cadillac");
    System.out.println(cadillac.gasAmount);
  }
}
