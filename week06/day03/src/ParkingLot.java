import java.util.ArrayList;
import java.util.HashMap;

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

  public int countCarTypesAndColors(CarType carType, Color color) {
    int counter = 0;
    for (int i = 0; i <parkingLot.size() ; i++) {
      if (parkingLot.get(i).carType.equals(carType) && parkingLot.get(i).color.equals(color)) {
        counter ++;
      }
    }
    return counter;
  }

  public HashMap<String, Integer> carTypes(ArrayList<Car> listOfCars) {
    HashMap<String, Integer> carTypes = new HashMap<>();
    for (int i = 0; i < listOfCars.size(); i++) {
      String key = listOfCars.get(i).color + " " + listOfCars.get(i).carType;
      if (carTypes.containsKey(key)) {
        int val = carTypes.get(key);
        carTypes.put(key, val + 1);
      } else {
        carTypes.put(key, 1);
      }
    }
    return carTypes;
  }

  public static void main(String[] args) {
    ParkingLot parkingLot = new ParkingLot();
    System.out.println("We have: " + parkingLot.countCarTypes(CarType.TRABANT) + " Trabants in our car park");
    System.out.println("We have: " + parkingLot.countCarTypes(CarType.ZSIGULI) + " Zsigulis in our car park");
    System.out.println();
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.TRABANT, Color.BLACK) + " black Trabants in our car park");
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.TRABANT, Color.RED) + " red Trabants in our car park");
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.TRABANT, Color.BLUE) + " blue Trabants in our car park");
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.TRABANT, Color.GREEN) + " green Trabants in our car park");
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.TRABANT, Color.PURPLE) + " purple Trabants in our car park");
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.TRABANT, Color.YELLOW) + " yellow Trabants in our car park");
    System.out.println();
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.ZSIGULI, Color.BLACK) + " black Zsigulis in our car park");
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.ZSIGULI, Color.RED) + " red Zsigulis in our car park");
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.ZSIGULI, Color.BLUE) + " blue Zsigulis in our car park");
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.ZSIGULI, Color.GREEN) + " green Zsigulis in our car park");
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.ZSIGULI, Color.PURPLE) + " purple Zsigulis in our car park");
    System.out.println("We have: " + parkingLot.countCarTypesAndColors(CarType.ZSIGULI, Color.YELLOW) + " yellow Zsigulis in our car park");
    System.out.println();
    System.out.println(parkingLot.carTypes(parkingLot.parkingLot));
  }

}
