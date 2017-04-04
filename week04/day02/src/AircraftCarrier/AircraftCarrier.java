package AircraftCarrier;

import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class AircraftCarrier {
  int airplaneSlots;
  int ammoStoreage;
  int health;
  ArrayList<Aircrafts> listOfAirplanes;

  public AircraftCarrier(int ammoStoreage) {
    this.ammoStoreage = ammoStoreage;
    this.health = 1000;
    this.airplaneSlots = 10;
    this.listOfAirplanes = new ArrayList<Aircrafts>();
  }

  public void addPlanes(String plane) {

  }
}
