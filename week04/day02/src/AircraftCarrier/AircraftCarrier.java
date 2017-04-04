package AircraftCarrier;

import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class AircraftCarrier {

  int airplaneSlots;
  int ammoStoreage;
  int health;
  int totalDamage;
  int avaiableAmmo;
  ArrayList<Aircrafts> listOfAirplanes;

  public AircraftCarrier(int ammoStoreage) {
    this.ammoStoreage = ammoStoreage;
    this.avaiableAmmo = ammoStoreage;
    this.health = 10000;
    this.airplaneSlots = 10;
    this.listOfAirplanes = new ArrayList<Aircrafts>();
  }

  public void addPlanes(String plane) {
    if (airplaneSlots == 0) {
      System.out.println("Sorry the Aircraft carrier is full. No more room for new planes");
    } else if (plane == "F16") {
      F16 F16 = new F16();
      listOfAirplanes.add(F16);
      airplaneSlots -= 1;
    } else {
      F35 F35 = new F35();
      listOfAirplanes.add(F35);
      airplaneSlots -= 1;
    }
  }

  public void fight(AircraftCarrier otherShip) {
    for (Aircrafts planes : listOfAirplanes) {
      totalDamage = totalDamage + planes.fight();
    }
    otherShip.health = otherShip.health - totalDamage;
  }

  public void fill() {
    int filling = 0;
    for (Aircrafts planes : listOfAirplanes) {
      filling = (planes.getMaxAmmo() - planes.getAmmo());
      if (filling < avaiableAmmo) {
        planes.refill(avaiableAmmo);
        avaiableAmmo = (avaiableAmmo - filling);
      } else {
        System.out.println("out of Ammo");
      }
    }
  }

  public void getPlanesStatus() {
    for (Aircrafts planes : listOfAirplanes) {
      totalDamage = totalDamage + planes.fight();
    }
    System.out.println(
        "Aircraft count: " + listOfAirplanes.size() + ", Ammo Storage: " + avaiableAmmo
            + ", Total damage: " + totalDamage);
    System.out.println("Aircrafts:");
    for (Aircrafts planes : listOfAirplanes) {
      planes.getStatus();
    }
    System.out.println();
    if (health == 0) {
      System.out.println("It`s dead Jim :(");
    } else {
      System.out.println("Good job Jim, your health is: " + health);
    }
  }
}
