package Pirates;

import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class Ship {
  static int shipIDsCreated = 1;
  ArrayList<Pirate> crew;
  int id, shipScore, alivePirates;
  Captain captain;
  Parrot parrot;
  boolean isThisShipWins;

  public Ship() {
    crew = new ArrayList<>();
  }

  public void fillShip() {
    Captain captain = new Captain();
    crew.add(captain);
    Parrot parrot = new Parrot("George");
    crew.add(parrot);
    int piratesInTheCrew = (int) (Math.random() * 100);
    for (int i = 0; i < piratesInTheCrew; i++) {
      Pirate p = new Pirate();
    crew.add(p);
    }
  }

  public void show() {
    System.out.println("Ship id: " + id + "`s captain is " + captain.getRumsDrank() + " so he is " + captain.getState() + " Alive crew: " + getAliveCrewCount() + "and a parrot");
  }

  private int getAliveCrewCount() {
    int alivePirates = 0;
    for (Pirate p : crew) {
      alivePirates += (!(p instanceof Captain) && !p.isDead) ? 1 : 0;
    }
    return alivePirates;
  }

  public void isThisShipWin(Ship otherShip) {
    if (this.shipScore > otherShip.shipScore) {
      isThisShipWins = true;
    } else {
      isThisShipWins = false;
    }
  }

  public void calculateShipScore() {
    shipScore = getAliveCrewCount() - captain.getRumsDrank();
  }

  public void losses() {
    alivePirates = getAliveCrewCount() - ((int) Math.random() * getAliveCrewCount());
  }

  public int randomNumberOfRums() {
    int numberOfRums = (int) Math.random() * (alivePirates*5);
    return numberOfRums;
  }

  public void winner() {
    System.out.println("Yehaa.. Party time!! Let`s get drunk! We have " + randomNumberOfRums());
    captain.drinkSomeRum();
    parrot.drinkSomeRum();
  }
}
