package Garden;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class Garden {

  public List<Plant> plantsInTheGarden;
  double wateringAmount;

  public Garden() {
    this.plantsInTheGarden = new ArrayList<>();
    add();
  }

  public void waterAmount(double waterAmount) {
    wateringAmount = waterAmount / plantsInTheGarden.size();
    System.out.println("Watering with " + waterAmount);
  }

  public void add() {
    Flower yellowFlower = new Flower("yellow", 0.0);
    plantsInTheGarden.add(yellowFlower);
    Flower blueFlower = new Flower("blue", 0.0);
    plantsInTheGarden.add(blueFlower);
    Tree purpleTree = new Tree("purple", 0.0);
    plantsInTheGarden.add(purpleTree);
    Tree orangeTree = new Tree("purple", 0.0);
    plantsInTheGarden.add(orangeTree);
  }
}
