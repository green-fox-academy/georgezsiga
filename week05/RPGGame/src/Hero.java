/**
 * Created by georgezsiga on 4/10/17.
 */
public class Hero extends Character {

  public Hero() {
  super();
  this.maxHP = 38;
  this.currentHP = (20 + rollTheDice());
  this.defendPoint = (2 * rollTheDice());
  this.strikePoint = (5 + rollTheDice());
  }

}
