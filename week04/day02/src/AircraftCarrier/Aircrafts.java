package AircraftCarrier;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class Aircrafts {
  int ammo;
  int damage;
  int maxAmmo;
  int baseDamage;
  String name;

  public Aircrafts() {
    this(0, 0);
  }

  public Aircrafts(int maxAmmo, int baseDamage) {
    this.maxAmmo = maxAmmo;
    this.baseDamage = baseDamage;
    ammo = 0;
    damage = 0;
    name = "airplane";
  }

  public void refill(int refillAmmo) {

  }

  public int getAmmo() {
    return ammo;
  }

  public int getMaxAmmo() {
    return maxAmmo;
  }



  public int flight() {
    return damage;
  }

  public void getStatus() {

  }

}
