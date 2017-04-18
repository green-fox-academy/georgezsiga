import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/13/17.
 */
public class TestRandomMap {

  int testBoxX, testBoxY;
  Area area;
  Monster monster;
  ArrayList<Monster> monsterMap;
  ArrayList<GameObject> wallMap;
  ArrayList<GameObject> testedMap;
  ArrayList<Hero> heroMap;
  GameObject wall;
  Hero testHero;
  Boss boss;
  Skeleton skeleton;

  public TestRandomMap(Area areaInherited) {
    this.area = areaInherited;
    this.monsterMap = areaInherited.monsterMap;
    this.monster = areaInherited.monster;
    this.testHero = areaInherited.hero;
    this.boss = areaInherited.boss;
    this.skeleton = areaInherited.skeleton;
    this.wallMap = areaInherited.wallMap;
    this.heroMap = areaInherited.heroMap;
  }

//  public void checkCutOutSections() {
//    int counter = wallMap.size();
//    int floorTiles = 100 - counter;
//    testedMap = new ArrayList<>();
//
//    testHero = new Hero(ImageLoader.getInstance().GYURI, 0, 0);
//    for (int i = 0; i < randomMap.size(); i++) {
//      if (randomMap.get(i).getPosX() == testHero.getPosX() && randomMap.get(i).getPosY() == testHero
//          .getPosY() && !testedMap.contains(randomMap.get(i))) {
//        testedMap.add(wallMap.get(i));
//      }
//    }
//    heroMoveUp();
//    heroMoveDown();
//    heroMoveLeft();
//    heroMoveRight();
//  }

  private void heroMoveRight() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == testHero.getPosX() + 1 && wallMap.get(i).getPosY() == testHero
          .getPosY() && !testedMap.contains(wallMap.get(i))) {
        canIgoThere = false;
        testedMap.add(wallMap.get(i));
      }
    }
    if (testHero.getPosX() < 9 && canIgoThere) {
      testHero.setPosX(testHero.getPosX() + 1);
    }
  }

  private void heroMoveLeft() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == testHero.getPosX() - 1 && wallMap.get(i).getPosY() == testHero
          .getPosY()) {
        canIgoThere = false;
      }
    }
    if (testHero.getPosX() > 0 && canIgoThere) {
      testHero.setPosX(testHero.getPosX() - 1);
    }
  }

  private void heroMoveUp() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == testHero.getPosX()
          && wallMap.get(i).getPosY() == testHero.getPosY() - 1) {
        canIgoThere = false;
      }
    }
    if (testHero.getPosY() > 0 && canIgoThere) {
      testHero.setPosY(testHero.getPosY() - 1);
    }
  }

  private void heroMoveDown() {
    boolean canIgoThere = true;
    for (int i = 0; i < wallMap.size(); i++) {
      if (wallMap.get(i).getPosX() == testHero.getPosX()
          && wallMap.get(i).getPosY() == testHero.getPosY() + 1) {
        canIgoThere = false;
      }
    }
    if (testHero.getPosY() < 9 && canIgoThere) {
      testHero.setPosY(testHero.getPosY() + 1);
    }
  }

}
