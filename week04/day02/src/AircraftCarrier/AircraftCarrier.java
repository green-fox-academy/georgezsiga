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


}
