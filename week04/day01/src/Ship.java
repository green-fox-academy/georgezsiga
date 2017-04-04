import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class Ship {
  static int shiipIDsCreated = 1;
  ArrayList<Pirate> crew;
  int id;
  Captain captain;

  public Ship() {
    crew = new ArrayList<>();
  }

  public void fillShip() {
    Captain captain = new Captain();
    crew.add(captain);
    int piratesInTheCrew = (int) (Math.random() * 100);
    for (int i = 0; i < piratesInTheCrew; i++) {
      Pirate p = new Pirate();
    crew.add(p);
    }
  }

  public void show() {
    System.out.println("Ship id: " + id + "`s captain is " + captain.getRumsDrank() + " so he is " + captain.getState() + " Alive crew: " + getAliveCrewCount());
  }

  private int getAliveCrewCount() {
    int alivePirates = 0;
    for (Pirate p : crew) {
      alivePirates += (!(p instanceof Captain) && !p.isDead()) ? 1 : 0;
    }
    return alivePirates;
  }
}
