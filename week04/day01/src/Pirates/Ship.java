package Pirates;

import static java.lang.System.out;

import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class Ship {

  static int shipIDsCreated = 1;
  ArrayList<Pirate> crew;
  private int id, shipScore, alivePirates, armadaID;
  Captain captain;
  Parrot parrot;
  boolean isThisShipWins;

  public Ship() {
    crew = new ArrayList<>();
    id = shipIDsCreated++;
    this.armadaID = armadaID;
  }

  public int getId() {
    return id;
  }

  public Captain getCaptain() {
    return captain;
  }

  public Parrot getParrot() {
    return parrot;
  }

  public void fillShip() {
    captain = new Captain();
    crew.add(captain);
    parrot = new Parrot("George");
    crew.add(parrot);
    int piratesInTheCrew = (int) (Math.random() * 100);
    for (int i = 0; i < piratesInTheCrew; i++) {
      Pirate p = new Pirate();
      crew.add(p);
    }
  }

  public void show() {
    System.out.println(
        "Ship id: " + getId() + "`s captain has drunk " + getCaptain().getRumsDrank() + " rum, so he is "
            + getCaptain().getState() + ". Alive crew: " + getAliveCrewCount()
            + " and a parrot, called: " + getParrot().name + ".");
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


  public void losses() {
    alivePirates = getAliveCrewCount() - ((int) Math.random() * getAliveCrewCount());
  }

  public void winner() {
    show();
    System.out.println("Has won the battle");
    int numberOfRums = (int) (Math.random() * (crew.size() * 2));
    System.out.println(
        "Yehaa.. Party time!! Let`s get drunk! We have " + numberOfRums + " barrel of rums.");
    captain.drinkSomeRum();
    parrot.drinkSomeRum();
    System.out.println();
  }

  public boolean battle(Ship othership) {
    show();
    System.out.println("Will attack this ship:");
    othership.show();
    System.out.println();

    int thisShipScore = this.getAliveCrewCount() - captain.getRumsDrank();
    int otherShipScore = othership.getAliveCrewCount() - othership.captain.getRumsDrank();

    Ship wins = (thisShipScore >= otherShipScore) ? this : othership;
    Ship lose = (thisShipScore < otherShipScore) ? this : othership;

    lose.losses();
    wins.winner();

    return (thisShipScore >= otherShipScore) ? true : false;
  }
}
