package Garden;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class Flower extends Garden {

  public Flower(String color, Double waterAmount) {
    this.color = color;
    this.waterAmount = waterAmount;
  }

  public void wateringFlower(Double wateringAmount) {
    if (waterAmount < 5) {
      waterAmount = waterAmount + (wateringAmount*0.75);
    }
  }


}
