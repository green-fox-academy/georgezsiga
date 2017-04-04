package AircraftCarrier;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class F35 extends Aircrafts{
  int maxAmmo = 12;
  int baseDamage = 50;

  public void F35() {
    ammo = 0;
  }

  public String getType() {
    this.name = "F35";
    return name;
  }

  public void getStatus() {
    System.out.println("Type: " + getType() + ", Ammo: " + ammo + ", Base Damage: " + baseDamage + ", All Damage: " + (ammo*baseDamage));
  }
}
