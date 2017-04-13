import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/11/17.
 */
public class GameLogic {
//  Area area = new Area();

  Area area;
  Monster monster;
  ArrayList<Monster> monsterMap;
  ArrayList<GameObject> wallMap;
  ArrayList<Hero> heroMap;
  Hero hero;
  Boss boss;
  Skeleton skeleton;

  public GameLogic(Area areaInherited) {
    this.area = areaInherited;
    this.monsterMap = areaInherited.monsterMap;
    this.monster = areaInherited.monster;
    this.hero = areaInherited.hero;
    this.boss = areaInherited.boss;
    this.skeleton = areaInherited.skeleton;
    this.wallMap = areaInherited.wallMap;
    this.heroMap = areaInherited.heroMap;
  }

  public  static int rollTheDice() {
    int diceRoll = (int) (Math.random() * 6 + 1);
    return diceRoll;
  }

  public static int randomNumber() {
    int rNumber = (int) (Math.random() * 10);
    return rNumber;
  }

  public static int randomMonsters() {
    int rNumber = (int) (Math.random() * 3 + 1);
    return rNumber;
  }

  public static int randomMove() {
    int rNumber = (int) (Math.random() * 4);
    return rNumber;
  }

  public static int randomTiles() {
    int rNumber = (int) (Math.random() * 2);
    return rNumber;
  }

  public void battle() {
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monster.getPosX() == hero.getPosX() && monster.getPosY() == hero.getPosY()) {
        while (hero.getCurrentHP() > 0 && monster.getCurrentHP() > 0) {
          heroStrikes();
          monsterStrikes();
        }
      }
    }
  }

  public void heroStrikes() {
    int strikeValue = hero.getStrikeSP() + (2 * GameLogic.rollTheDice());
    if (strikeValue > monster.getDefendDP()) {
      if (monster.getCurrentHP() <= (strikeValue - monster.getDefendDP())) {
        if (monster.isGotKey() && !monsterMap.contains(boss)) {
          hero.heroLevelUp();
          area.levelUpArea();
        } else if (monster == boss && !monsterMap.contains(skeleton)) {
          hero.heroLevelUp();
          area.levelUpArea();
        } else {
          monster.setCurrentHP(0);
          monsterMap.remove(monster);
          wallMap.remove(monster);
          hero.heroLevelUp();
        }
      }
    }
    int decreasedHP = monster.getCurrentHP() - (strikeValue - monster.getDefendDP());
    monster.setCurrentHP(decreasedHP);
  }

  public void monsterStrikes() {
    int strikeValue = monster.getStrikeSP() + (2 * GameLogic.rollTheDice());
    if (strikeValue > hero.getDefendDP()) {
      if (hero.getCurrentHP() <= (strikeValue - hero.getDefendDP())) {
        hero.setCurrentHP(0);
        heroMap.remove(hero);
      }
      int decreasedHP = hero.getCurrentHP() - (strikeValue - hero.getDefendDP());
      hero.setCurrentHP(decreasedHP);
    }
  }

}
