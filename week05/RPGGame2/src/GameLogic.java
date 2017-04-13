import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/11/17.
 */
public class GameLogic {

  int SIZE, testBoxX, testBoxY;
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
    SIZE = GameObject.SIZE;
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
  public void heroMoveRight() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == hero.getPosX() + SIZE && wall.getPosY() == hero.getPosY()) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monster.getPosX() == hero.getPosX() + SIZE && monster.getPosY() == hero.getPosY()) {
        canIgoThere = true;
      }
    }
    if (hero.getPosX() < SIZE * 9 && canIgoThere) {
      testBoxX = hero.getPosX() + SIZE;
      hero.setPosX(testBoxX);
      hero.image = hero.getImage("assets/hero-right.png");
    } else {
      hero.image = hero.getImage("assets/hero-right.png");
    }
  }

  public void heroMoveLeft() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == hero.getPosX() - SIZE && wall.getPosY() == hero.getPosY()) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monster.getPosX() == hero.getPosX() - SIZE && monster.getPosY() == hero.getPosY()) {
        canIgoThere = true;
      }
    }
    if (hero.getPosX() > 0 && canIgoThere) {
      testBoxX = hero.getPosX() - SIZE;
      hero.setPosX(testBoxX);
      hero.image = hero.getImage("assets/hero-left.png");
    } else {
      hero.image = hero.getImage("assets/hero-left.png");
    }
  }

  public void heroMoveDown() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY() + SIZE) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monster.getPosX() == hero.getPosX() && monster.getPosY() == hero.getPosY() + SIZE) {
        canIgoThere = true;
      }
    }
    if (hero.getPosY() < SIZE * 9 && canIgoThere) {
      testBoxY = hero.getPosY() + SIZE;
      hero.setPosY(testBoxY);
      hero.image = hero.getImage("assets/hero-down.png");
    } else {
      hero.image = hero.getImage("assets/hero-down.png");
    }
  }

  public void heroMoveUp() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY() - SIZE) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monster.getPosX() == hero.getPosX() && monster.getPosY() == hero.getPosY() - SIZE) {
        canIgoThere = true;
      }
    }
    if (hero.getPosY() > 0 && canIgoThere) {
      testBoxY = hero.getPosY() - SIZE;
      hero.setPosY(testBoxY);
      hero.image = hero.getImage("assets/hero-up.png");
    } else {
      hero.image = hero.getImage("assets/hero-up.png");

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
      if (wall.getPosX() == monster.getPosX() + SIZE && wall.getPosY() == monster.getPosY()) {
        canIgoThere = false;
      }
    }
    if (monster.getPosX() < SIZE * 9 && canIgoThere) {
      testBoxX = monster.getPosX() + SIZE;
      monster.setPosX(testBoxX);
    }
  }

  private void moveMonsterLeft() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == monster.getPosX() - SIZE && wall.getPosY() == monster.getPosY()) {
        canIgoThere = false;
      }
    }
    if (monster.getPosX() > 0 && canIgoThere) {
      testBoxX = monster.getPosX() - SIZE;
      monster.setPosX(testBoxX);
    }
  }

  private void moveMonsterUp() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == monster.getPosX() && wall.getPosY() == monster.getPosY() - SIZE) {
        canIgoThere = false;
      }
    }
    if (monster.getPosY() > 0 && canIgoThere) {
      testBoxX = monster.getPosY() - SIZE;
      monster.setPosY(testBoxX);
    }
  }

  private void moveMonsterDown() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == monster.getPosX() && wall.getPosY() == monster.getPosY() + SIZE) {
        canIgoThere = false;
      }
    }
    if (monster.getPosY() < SIZE * 9 && canIgoThere) {
      testBoxX = monster.getPosY() + SIZE;
      monster.setPosY(testBoxX);
    }
  }
}
