/**
 * Created by georgezsiga on 4/10/17.
 */
public class Boss extends Monster {

  public Boss(String filename, int posX, int posY) {
    super(filename, posX, posY);
    this.level = 1;
    this.maxHP = (2 * levelOfGame * 6) + 6;
    this.currentHP = (2 * levelOfGame * gameLogic.rollTheDice()) + gameLogic.rollTheDice();
    this.defendDP = (levelOfGame / 2 * gameLogic.rollTheDice()) + gameLogic.rollTheDice();
    this.strikeSP = (levelOfGame * gameLogic.rollTheDice()) + levelOfGame;
  }
}
