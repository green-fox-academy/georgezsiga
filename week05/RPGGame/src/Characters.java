/**
 * Created by georgezsiga on 4/10/17.
 */
public class Characters {
  int maxHP;
  int currentHP;
  int defendPoint;
  int strikePoint;
  boolean isDead;

  public Characters() {
    this.maxHP = 1;
    this.currentHP = 1;
    this.defendPoint = 1;
    this.strikePoint = 1;
    this.isDead = false;
  }

  public boolean isDead() {
    return isDead;
  }
}
