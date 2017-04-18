import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Area extends JComponent implements KeyListener {

  int testBoxX, testBoxY;
  GameLogic gameLogic;
  ArrayList<GameObject> finalMap, wallMap;
  ArrayList<Monster> monsterMap;
  ArrayList<Hero> heroMap;
  GameObject wall;
  Hero hero;
  Monster monster;
  Boss boss;
  Skeleton skeleton;

  public Area() {
    RandomMap randomMap = new RandomMap();
    finalMap = new ArrayList<>();
    finalMap = randomMap.getFinalMap();
    testBoxX = 0;
    testBoxY = 0;
    wallMap = new ArrayList<>();
    addWall();
    heroMap = new ArrayList<>();
    addHero();
    monsterMap = new ArrayList<>();
    addMonsters(1);
    setPreferredSize(new Dimension(720, 800));
    setVisible(true);
    gameLogic = new GameLogic(this);
  }

  public void levelUpArea() {
    RandomMap randomMap = new RandomMap();
    finalMap = new ArrayList<>();
    finalMap = randomMap.getFinalMap();
    hero.setPosX(0);
    hero.setPosY(0);
    hero.heroRestoreHP();
    this.wallMap = new ArrayList<>();
    addWall();
    this.monsterMap = new ArrayList<>();
    int newMapLevel = monster.getMapLevel() + 1;
    addMonsters(newMapLevel);
    gameLogic = new GameLogic(this);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    Graphics2D g2d = (Graphics2D) graphics;
    drawRandomMap(graphics);
    drawMonsters(graphics);
    drawHero(graphics);
    isHeroDead(g2d);
  }

  private void drawRandomMap(Graphics graphics) {
    for (int i = 0; i < finalMap.size(); i++) {
      GameObject tile = finalMap.get(i);
      tile.draw(graphics);
    }
  }

  private void drawHero(Graphics graphics) {
    for (int i = 0; i < heroMap.size(); i++) {
      GameObject hero = heroMap.get(i);
      hero.draw(graphics);
    }
  }

  private void drawMonsters(Graphics graphics) {
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      monster.draw(graphics);
    }
  }

  public void isHeroDead(Graphics2D g2d) {
    if (heroMap.size() == 0) {
      gameMessages(g2d, "You died! Game over.");
    } else {
      g2d.drawString(hero.toString(), 216, 760);
      monsterStats(g2d);
    }
  }

  public void monsterStats(Graphics2D graphics2D) {
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      graphics2D.drawString("Level : " + monster.getMapLevel(), 330, 740);
      if (monster.getPosX() == hero.getPosX() && monster.getPosY() == hero.getPosY()) {
        graphics2D.drawString(monster.toString(), 216, 780);
      }
    }
  }

  private void gameMessages(Graphics2D graphics2D, String gameMessage) {
    graphics2D.drawString(gameMessage, 288, 760);
  }

  public void addMonsters(int newMapLevel) {
    addBoss(newMapLevel);
//    addSkeleton(true, newMapLevel);
//    for (int i = 0; i < GameLogic.randomMonsters(); i++) {
//      addSkeleton(false, newMapLevel);
    addSkeletonKond(true, newMapLevel);
    addSkeletonSzilvi(false, newMapLevel);
    addSkeletonTojas(false, newMapLevel);
//    }
  }

  public void addHero() {
//    hero = new Hero(ImageLoader.getInstance().HERO_DOWN, testBoxX, testBoxY);
    hero = new Hero(ImageLoader.getInstance().GYURI, testBoxX, testBoxY);       // mentor game
    heroMap.add(hero);
  }

  public void addBoss(int newMaplevel) {
    int x = GameLogic.randomNumber();
    int y = GameLogic.randomNumber();
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        int wallx = wall.getPosX();
        int wally = wall.getPosY();
        if (wallx == x && wally == y) {
          x = GameLogic.randomNumber();
          y = GameLogic.randomNumber();
        } else {
//          boss = new Boss(ImageLoader.getInstance().BOSS, x, y, newMaplevel);
          boss = new Boss(ImageLoader.getInstance().AZE, x, y, newMaplevel);           // mentor game
          isItFree = true;
        }
      }
    }
    wallMap.add(boss);
    monsterMap.add(boss);
  }

  public void addSkeleton(boolean gotKey, int newMapLevel) {
    int x = GameLogic.randomNumber();
    int y = GameLogic.randomNumber();
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if ((wall.getPosX() == x) && (wall.getPosY() == y)) {
          x = GameLogic.randomNumber();
          y = GameLogic.randomNumber();
        } else {
          skeleton = new Skeleton(ImageLoader.getInstance().SKELETON, x, y, gotKey, newMapLevel);
          isItFree = true;
        }
      }
    }
    wallMap.add(skeleton);
    monsterMap.add(skeleton);
  }

  public void addSkeletonKond(boolean gotKey, int newMapLevel) {  // mentor game
    int x = GameLogic.randomNumber();
    int y = GameLogic.randomNumber();
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if ((wall.getPosX() == x) && (wall.getPosY() == y)) {
          x = GameLogic.randomNumber();
          y = GameLogic.randomNumber();
        } else {
          skeleton = new Skeleton(ImageLoader.getInstance().KOND, x, y, gotKey, newMapLevel);
          isItFree = true;
        }
      }
    }
    wallMap.add(skeleton);
    monsterMap.add(skeleton);
  }

  public void addSkeletonTojas(boolean gotKey, int newMapLevel) {    //  mentor game
    int x = GameLogic.randomNumber();
    int y = GameLogic.randomNumber();
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if ((wall.getPosX() == x) && (wall.getPosY() == y)) {
          x = GameLogic.randomNumber();
          y = GameLogic.randomNumber();
        } else {
          skeleton = new Skeleton(ImageLoader.getInstance().TOJAS, x, y, gotKey, newMapLevel);
          isItFree = true;
        }
      }
    }
    wallMap.add(skeleton);
    monsterMap.add(skeleton);
  }

  public void addSkeletonSzilvi(boolean gotKey, int newMapLevel) {        // mentor game
    int x = GameLogic.randomNumber();
    int y = GameLogic.randomNumber();
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if ((wall.getPosX() == x) && (wall.getPosY() == y)) {
          x = GameLogic.randomNumber();
          y = GameLogic.randomNumber();
        } else {
          skeleton = new Skeleton(ImageLoader.getInstance().SZILVI, x, y, gotKey, newMapLevel);
          isItFree = true;
        }
      }
    }
    wallMap.add(skeleton);
    monsterMap.add(skeleton);
  }

  public void addWall() {
    for (int i = 1; i < finalMap.size(); i++) {
      if (finalMap.get(i) instanceof Wall) {
        wallMap.add(finalMap.get(i));
      } else {

      }
    }
  }

  @Override
  public void keyTyped(KeyEvent keyEvent) {

  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {

  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      gameLogic.heroMoveUp();
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      gameLogic.heroMoveDown();
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      gameLogic.heroMoveLeft();
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      gameLogic.heroMoveRight();
    } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      gameLogic.battle();
    }
    repaint();
    timer.start();
  }

  javax.swing.Timer timer = new javax.swing.Timer(500, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      gameLogic.moveMonster();
      repaint();
    }
  });
}
