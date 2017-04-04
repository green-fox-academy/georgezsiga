package Garden;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class Tree extends Garden {



  public Tree(String color, Double waterAmount) {
    this.color = color;
    this.waterAmount = waterAmount;
  }

  public void wateringTree(Double wateringAmount) {
    if (waterAmount < 10) {
      waterAmount = waterAmount + (wateringAmount * 0.4);
    }
  }

  public void status() {
    if (waterAmount < 10) {
      System.out.println("The " + color + " tree needs water");
    } else {
      System.out.println("The " + color + " tree doesn`t need water");
    }
  }
}
