package Garden;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class Main {

  public static void main(String[] args) {
    Garden garden = new Garden();
    for (Plant plants : garden.plantsInTheGarden) {
      plants.status();
    }
    System.out.println();

    garden.waterAmount(40);
    for (Plant plants : garden.plantsInTheGarden) {
      plants.watering(garden.wateringAmount);
      plants.status();
    }
    System.out.println();

    garden.waterAmount(70);
    for (Plant plants : garden.plantsInTheGarden) {
      plants.watering(garden.wateringAmount);
      plants.status();
    }
  }
}
