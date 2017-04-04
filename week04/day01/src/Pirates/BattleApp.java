package Pirates;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class BattleApp {

  public static void main(String[] args) {
    Ship ship1 = new Ship();
    ship1.fillShip();
    Ship ship2 = new Ship();
    ship2.fillShip();
    ship1.battle(ship2);
  }
}
