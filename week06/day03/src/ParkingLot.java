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
      Car car = new Car(randomCarType(), randomColor());
      parkingLot.add(car);
    }
  }

  public CarType randomCarType() {
    CarType type;
    int randNum = (int) (Math.random()*2);
    if (randNum == 0) {
      type = CarType.TRABANT;
    } else {
      type = CarType.ZSIGULI;
    }
    return type;
  }

  public Color randomColor() {
    Color color;
    Color[] colors = {Color.BLACK, Color.BLUE, Color.GREEN, Color.PURPLE, Color.RED, Color.YELLOW};
    int randNum = (int) (Math.random()*6);
    color = colors[randNum];
    return color;
  }

  public int countCarTypes(CarType carType) {
    int counter = 0;
    for (int i = 0; i <parkingLot.size() ; i++) {
      if (parkingLot.get(i).carType.equals(carType)) {
        counter ++;
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    ParkingLot parkingLot = new ParkingLot();
    System.out.println("We have: " + parkingLot.countCarTypes(CarType.TRABANT) + " Trabants in our car park");
    System.out.println("We have: " + parkingLot.countCarTypes(CarType.ZSIGULI) + " Zsigulis in our car park");
  }

}
