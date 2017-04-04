package AircraftCarrier;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class F16 extends Aircrafts {
  int maxAmmo = 8;
  int baseDamage = 30;

  public void F16() {
    ammo = 0;
  }

  public String getType() {
    this.name = "F16";
    return name;
  }

  public void getStatus() {
    System.out.println("Type: " + getType() + ", Ammo: " + ammo + ", Base Damage: " + baseDamage + ", All Damage: " + (ammo*baseDamage));
  }

}
