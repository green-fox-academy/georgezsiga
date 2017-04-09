package Pirates;

import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/8/17.
 */
public class Armada {
  ArrayList<Ship> ships;
  static int armadaIDCreated = 1;
  private int armadaId;

  public Armada() {
    ships = new ArrayList<>();
    armadaId = armadaIDCreated++;
  }

  public void fillArmada() {
    int shipsInTheArmada = (int) (Math.random() * 10);
    for (int i = 0; i < shipsInTheArmada; i++) {
      Ship s = new Ship();
      s.fillShip();
      ships.add(s);
    }
  }

  public int getArmadaID() {
    return armadaId;
  }


  public ArrayList<Ship> getShips() {
    return ships;
  }


  public void show() {
    System.out.println(
        "Armada id: " + getArmadaID() + " has " + (ships.size() +1) + " ships in it.");
  }

  public void armadaWar(Armada otherArmada) {
    show();
    System.out.println("Will attack this armada:");
    otherArmada.show();
    System.out.println();
    while (getShips().size() > 0 && otherArmada.getShips().size() > 0) {
      Ship shipThisArmada = getShips().get(0);
      Ship shipOtherArmada = otherArmada.getShips().get(0);
      if (shipThisArmada.battle(shipOtherArmada)) {
        otherArmada.getShips().remove(0);
      } else {
        getShips().remove(0);
      }
    }
    if (getShips().size() == 0) {
      System.out.println("Our Armada has lost the battle. The winner is:");
      otherArmada.show();
    } else {
      System.out.println("Our Armada has won the battle! The winner is:");
      show();
    }
  }
}
