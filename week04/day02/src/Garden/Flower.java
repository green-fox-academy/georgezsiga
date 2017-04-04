package Garden;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class Flower extends Plant {

  public Flower(String color, double waterAmount) {
    this.color = color;
    this.waterAmount = waterAmount;
  }

  public void watering(double wateringAmount) {
    if (waterAmount < 5) {
      waterAmount = waterAmount + (wateringAmount * 0.75);
    }
  }

  public void status() {
    if (waterAmount < 5) {
      System.out.println("The " + color + " flower needs water");
    } else {
      System.out.println("The " + color + " flower doesn`t need water");
    }
  }
}
