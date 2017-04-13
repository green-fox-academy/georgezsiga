import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/11/17.
 */
public class GameLogic {

  int testBoxX, testBoxY;
  Area area;
  Monster monster;
  ArrayList<Monster> monsterMap;
  ArrayList<GameObject> wallMap;
  ArrayList<Hero> heroMap;
  GameObject wall;
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

  public static int rollTheDice() {
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

  public void heroMoveRight() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == hero.getPosX() + 1 && wall.getPosY() == hero.getPosY()) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monster.getPosX() == hero.getPosX() + 1 && monster.getPosY() == hero.getPosY()) {
        canIgoThere = true;
      }
    }
    if (hero.getPosX() < 9 && canIgoThere) {
      testBoxX = hero.getPosX() + 1;
      hero.setPosX(testBoxX);
      hero.setImage(hero.getImage("assets/hero-right.png"));
    } else {
      hero.setImage(hero.getImage("assets/hero-right.png"));
    }
  }

  public void heroMoveLeft() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == hero.getPosX() - 1 && wall.getPosY() == hero.getPosY()) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monster.getPosX() == hero.getPosX() - 1 && monster.getPosY() == hero.getPosY()) {
        canIgoThere = true;
      }
    }
    if (hero.getPosX() > 0 && canIgoThere) {
      testBoxX = hero.getPosX() - 1;
      hero.setPosX(testBoxX);
      hero.setImage(hero.getImage("assets/hero-left.png"));
    } else {
      hero.setImage(hero.getImage("assets/hero-left.png"));
    }
  }

  public void heroMoveDown() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY() + 1) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monster.getPosX() == hero.getPosX() && monster.getPosY() == hero.getPosY() + 1) {
        canIgoThere = true;
      }
    }
    if (hero.getPosY() < 1 * 9 && canIgoThere) {
      testBoxY = hero.getPosY() + 1;
      hero.setPosY(testBoxY);
      hero.setImage(hero.getImage("assets/hero-down.png"));
    } else {
      hero.setImage(hero.getImage("assets/hero-down.png"));
    }
  }

  public void heroMoveUp() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY() - 1) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monster.getPosX() == hero.getPosX() && monster.getPosY() == hero.getPosY() - 1) {
        canIgoThere = true;
      }
    }
    if (hero.getPosY() > 0 && canIgoThere) {
      testBoxY = hero.getPosY() - 1;
      hero.setPosY(testBoxY);
      hero.setImage(hero.getImage("assets/hero-up.png"));
    } else {
      hero.setImage(hero.getImage("assets/hero-up.png"));


    }
  }

  public void moveMonster() {
    int randNum = GameLogic.randomMove();
    if (randNum == 0) {
      moveMonsterRight();
    } else if (randNum == 1) {
      moveMonsterDown();
    } else if (randNum == 2) {
      moveMonsterLeft();
    } else {
      moveMonsterUp();
    }
  }

  private void moveMonsterRight() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == monster.getPosX() + 1 && wall.getPosY() == monster.getPosY()) {
        canIgoThere = false;
      }
    }
    if (monster.getPosX() < 9 && canIgoThere) {
      testBoxX = monster.getPosX() + 1;
      monster.setPosX(testBoxX);
    }
  }

  private void moveMonsterLeft() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == monster.getPosX() - 1 && wall.getPosY() == monster.getPosY()) {
        canIgoThere = false;
      }
    }
    if (monster.getPosX() > 0 && canIgoThere) {
      testBoxX = monster.getPosX() - 1;
      monster.setPosX(testBoxX);
    }
  }

  private void moveMonsterUp() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == monster.getPosX() && wall.getPosY() == monster.getPosY() - 1) {
        canIgoThere = false;
      }
    }
    if (monster.getPosY() > 0 && canIgoThere) {
      testBoxX = monster.getPosY() - 1;
      monster.setPosY(testBoxX);
    }
  }

  private void moveMonsterDown() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == monster.getPosX() && wall.getPosY() == monster.getPosY() + 1) {
        canIgoThere = false;
      }
    }
    if (monster.getPosY() < 9 && canIgoThere) {
      testBoxX = monster.getPosY() + 1;
      monster.setPosY(testBoxX);
    }
  }
}
