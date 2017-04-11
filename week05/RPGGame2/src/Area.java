import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Area extends GameObject implements KeyListener {

  int testBoxX, testBoxY;
  String filename;
  ArrayList<Floor> floorMap;
  ArrayList<GameObject> wallMap;
  Hero hero;
  GameObject wall;
  Boss boss;
  Skeleton skeleton;

  public Area() {
    testBoxX = 0;
    testBoxY = 0;
    filename = "assets/hero-down.png";
    wallMap = new ArrayList<>();
    addWall();
    floorMap = new ArrayList<>();
    addFloor();
    addBoss();
    addSkeleton();
    addSkeleton();
    addSkeleton();
    setPreferredSize(new Dimension(720, 770));
    setVisible(true);
  }

  public void addBoss() {
    int x = randomNumber() * SIZE;
    int y = randomNumber() * SIZE;
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == x && wall.getPosY() == y) {
          x = (randomNumber() * SIZE);
          y = (randomNumber() * SIZE);
        } else {
          boss = new Boss("assets/boss.png", x, y);
          isItFree = true;
        }
      }
    }
    wallMap.add(boss);
  }

  public void addSkeleton() {
    int x = randomNumber() * SIZE;
    int y = randomNumber() * SIZE;
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == x && wall.getPosY() == y) {
          x = (randomNumber() * SIZE);
          y = (randomNumber() * SIZE);
        } else {
          skeleton = new Skeleton("assets/skeleton.png", x, y);
          isItFree = true;
        }
      }
    }
    wallMap.add(skeleton);
  }

  public void addWall() {
    for (int i = 1; i < 10; i += 2) {
      for (int j = 0; j < 10; j++) {
        if (j % 3 == 0) {

        } else {
          Wall wall = new Wall(i * SIZE, j * SIZE);
          wallMap.add(wall);
        }
      }
    }
  }


  public void addFloor() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Floor floor = new Floor(i * SIZE, j * SIZE);
        floorMap.add(floor);
      }
    }
  }

  public int randomNumber() {
    int rNumber = (int) (Math.random() * 10);
    return rNumber;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    for (int i = 0; i < floorMap.size(); i++) {
      Floor floor = floorMap.get(i);
      floor.draw(graphics);
    }
    for (int i = 0; i < wallMap.size(); i++) {
      GameObject wall = wallMap.get(i);
      wall.draw(graphics);
    }

    hero = new Hero(filename, testBoxX, testBoxY);
    hero.draw(graphics);
    Graphics2D g2d = (Graphics2D)graphics;
    g2d.drawString(hero.toString(), 100, 750);


  }

  @Override
  public void keyTyped(KeyEvent keyEvent) {

  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {

  }

  @Override
  public void keyReleased(KeyEvent e) {
    boolean canIgoThere = true;

    if (e.getKeyCode() == KeyEvent.VK_UP) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY() - SIZE) {
          canIgoThere = false;
        }
      }
      if (testBoxY > 0 && canIgoThere) {
        testBoxY -= SIZE;
        filename = "assets/hero-up.png";
      } else {
        filename = "assets/hero-up.png";
      }
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY() + SIZE) {
          canIgoThere = false;
        }
      }
      if (testBoxY < SIZE * 9 && canIgoThere) {
        testBoxY += SIZE;
        filename = "assets/hero-down.png";
      } else {
        filename = "assets/hero-down.png";
      }
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() - SIZE && wall.getPosY() == hero.getPosY()) {
          canIgoThere = false;
        }
      }
      if (testBoxX > 0 && canIgoThere) {
        testBoxX -= SIZE;
        filename = "assets/hero-left.png";
      } else {
        filename = "assets/hero-left.png";
      }
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() + SIZE && wall.getPosY() == hero.getPosY()) {
          canIgoThere = false;
        }
      }
      if (testBoxX < SIZE * 9 && canIgoThere) {
        testBoxX += SIZE;
        filename = "assets/hero-right.png";
      } else {
        filename = "assets/hero-right.png";
      }
    }
    repaint();
  }
}
