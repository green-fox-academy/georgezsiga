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
  ArrayList<Aircrafts> listOfAirplanes;

  public AircraftCarrier(int ammoStoreage) {
    this.ammoStoreage = ammoStoreage;
    this.health = 1000;
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

  public void fill() {
    for (Aircrafts planes : listOfAirplanes) {
      planes.refill(ammoStoreage);
    }
  }

  public void fight() {

  }

  public void getPlanesStatus() {
    for (Aircrafts planes : listOfAirplanes) {
      totalDamage = totalDamage + planes.damage;
    }
    System.out.println("Aircraft count: " + listOfAirplanes.size() + ", Ammo Storage: " + ammoStoreage + ", Total damage: " + totalDamage);
    System.out.println("Aircrafts:");
    for (Aircrafts planes : listOfAirplanes) {
      planes.getStatus();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    AircraftCarrier ship1 = new AircraftCarrier(45333);
    ship1.addPlanes("F35");
    ship1.addPlanes("F35");
    ship1.addPlanes("F35");
    ship1.addPlanes("F16");
    ship1.addPlanes("F16");
    ship1.fill();
    ship1.getPlanesStatus();
  }
}
