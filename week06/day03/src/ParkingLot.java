import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/19/17.
 */
public class ParkingLot {

  ArrayList<Car> parkingLot;

  public ParkingLot() {
    parkingLot = new ArrayList<>();
    addCars();
  }

  private void addCars() {
    for (int i = 0; i < 256 ; i++) {
      Car car = new Car(CarType.TRABANT, Color.BLACK);
      parkingLot.add(car);
    }
  }

  public static void main(String[] args) {

  }

}
