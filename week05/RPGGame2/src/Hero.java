import java.awt.image.BufferedImage;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Hero extends Character {

  public Hero(BufferedImage image, int posX, int posY) {
    super(image, posX, posY);
    this.level = 1;
    this.maxHP = 20 + (3 * GameLogic.rollTheDice());
    this.currentHP = maxHP;
    this.defendDP = 2 * GameLogic.rollTheDice();
    this.strikeSP = 5 + GameLogic.rollTheDice();
  }

  public void heroLevelUp() {
    int levelUp = getLevel() + 1;
    setLevel(levelUp);
    int maxHP = getMaxHP() + GameLogic.rollTheDice();
    setMaxHP(maxHP);
    int dp = getDefendDP() + GameLogic.rollTheDice();
    setDefendDP(dp);
    int sp = getStrikeSP() + GameLogic.rollTheDice();
    setStrikeSP(sp);
  }

  public void heroRestoreHP() {
    int maxHP = getMaxHP();
    int hp = getCurrentHP();
    int randNum = GameLogic.randomNumber();
    if (randNum == 1) {
      setCurrentHP(maxHP);
    } else if (randNum == 0 || randNum == 2 || randNum == 3 ) {
      int third = maxHP / 3;
      if ((hp + third) >= maxHP ) {
        setCurrentHP(maxHP);
      } else {
        setCurrentHP(hp+third);
      }
    } else {
      int tenth = maxHP / 10;
      if ((hp + tenth) >= maxHP ) {
        setCurrentHP(maxHP);
      } else {
        setCurrentHP(hp+tenth);
      }
    }
  }

  @Override
  public String toString() {
    return "Hero " +
        "(level " + level +
        ") HP: " + currentHP +
        "/" + maxHP +
        " | DP: " + defendDP +
        " | SP: " + strikeSP;
  }
}
