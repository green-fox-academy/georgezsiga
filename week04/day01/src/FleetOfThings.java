/**
 * Created by georgezsiga on 4/3/17.
 */
public class FleetOfThings {

  public static void main(String[] args) {
    Thing getMilk = new Thing("Get Milk");
    Thing removeObstacles = new Thing("Remove the obstacles");
    Thing standUp = new Thing("Stand up");
    Thing eatLunch = new Thing("Eat lunch");

    standUp.complete();
    eatLunch.complete();

    Fleet fleet = new Fleet();
    fleet.add(getMilk);
    fleet.add(removeObstacles);
    fleet.add(standUp);
    fleet.add(eatLunch);

    // Create a fleet of things to have this output:
    // 1. [ ] Get milk
    // 2. [ ] Remove the obstacles
    // 3. [x] Stand up
    // 4. [x] Eat lunch

    System.out.println(fleet);
  }
}