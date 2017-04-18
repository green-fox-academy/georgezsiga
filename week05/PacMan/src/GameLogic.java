import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/17/17.
 */
public class GameLogic {

  Area area;
  Monster monster;
  ArrayList<Monster> monsterMap;
  ArrayList<GameObject> wallMap, finalMap;
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
    this.finalMap = areaInherited.finalMap;
    this.heroMap = areaInherited.heroMap;
  }

  public static int rollTheDice() {
    int diceRoll = (int) (Math.random() * 6 + 1);
    return diceRoll;
  }

  public static int randomNumber() {
    int rNumber = (int) (Math.random() * 40);
    return rNumber;
  }

  public static int randomMonsters() {
    int rNumber = (int) (Math.random() * 8 + 1);
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

  public void heroMoveRight() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == hero.getPosX() + 1 && wallMap.get(i).getPosY() == hero
          .getPosY()) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      if (monsterMap.get(i).getPosX() == hero.getPosX() + 1 && monsterMap.get(i).getPosY() == hero.getPosY()) {
        canIgoThere = true;
      }
    }
    if (hero.getPosX() < 39 && canIgoThere) {
      hero.setPosX(hero.getPosX() + 1);
    } else if (hero.getPosX() == 39){
      hero.setPosX(0);
    }
  }

  public void heroMoveLeft() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == hero.getPosX() - 1 && wallMap.get(i).getPosY() == hero
          .getPosY()) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      if (monsterMap.get(i).getPosX() == hero.getPosX() - 1 && monsterMap.get(i).getPosY() == hero
          .getPosY()) {
        canIgoThere = true;
      }
    }
    if (hero.getPosX() > 0 && canIgoThere) {
      hero.setPosX(hero.getPosX() - 1);
    } else if (hero.getPosX() == 0) {
      hero.setPosX(39);
    }
  }

  public void heroMoveDown() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == hero.getPosX()
          && wallMap.get(i).getPosY() == hero.getPosY() + 1) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monsterMap.get(i).getPosX() == hero.getPosX()
          && monsterMap.get(i).getPosY() == hero.getPosY() + 1) {
        canIgoThere = true;
      }
    }
    if (hero.getPosY() < 39 && canIgoThere) {
      hero.setPosY(hero.getPosY() + 1);
    } else if (hero.getPosY() == 39) {
      hero.setPosY(0);
    }
  }

  public void heroMoveUp() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == hero.getPosX()
          && wallMap.get(i).getPosY() == hero.getPosY() - 1) {
        canIgoThere = false;
      }
    }
    for (int i = 0; i < monsterMap.size(); i++) {
      if (monsterMap.get(i).getPosX() == hero.getPosX()
          && monsterMap.get(i).getPosY() == hero.getPosY() - 1) {
        canIgoThere = true;
      }
    }
    if (hero.getPosY() > 0 && canIgoThere) {
      hero.setPosY(hero.getPosY() - 1);
    } else if (hero.getPosY() == 0) {
      hero.setPosY(39);
    }
  }

  public void moveMonster() {
    int randNum = GameLogic.randomMove();
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
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
    area.areTheyOnTheSameTile();
  }

  private void moveMonsterRight() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == monster.getPosX() + 1 && wallMap.get(i).getPosY() == monster
          .getPosY()) {
        canIgoThere = false;
      }
    }
    if (monster.getPosX() < 39 && canIgoThere) {
      monster.setPosX(monster.getPosX() + 1);
    } else if (monster.getPosX() == 39){
      monster.setPosX(0);
    }
  }

  private void moveMonsterLeft() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == monster.getPosX() - 1 && wallMap.get(i).getPosY() == monster
          .getPosY()) {
        canIgoThere = false;
      }
    }
    if (monster.getPosX() > 0 && canIgoThere) {
      monster.setPosX(monster.getPosX() - 1);
    } else if (monster.getPosX() == 0) {
      monster.setPosX(39);
    }
  }

  private void moveMonsterUp() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == monster.getPosX()
          && wallMap.get(i).getPosY() == monster.getPosY() - 1) {
        canIgoThere = false;
      }
    }
    if (monster.getPosY() > 0 && canIgoThere) {
      monster.setPosY(monster.getPosY() - 1);
    } else if (monster.getPosY() == 0) {
      monster.setPosY(39);
    }
  }

  private void moveMonsterDown() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == monster.getPosX()
          && wallMap.get(i).getPosY() == monster.getPosY() + 1) {
        canIgoThere = false;
      }
    }
    if (monster.getPosY() < 39 && canIgoThere) {
      monster.setPosY(monster.getPosY() + 1);
    } else if (monster.getPosY() == 39) {
      monster.setPosY(0);
    }
  }
}
