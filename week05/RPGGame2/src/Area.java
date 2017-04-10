import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Area extends GameObject implements KeyListener {

  int testBoxX;
  int testBoxY;
  int posX;
  int posY;
  int size;
  String filename;
  ArrayList<Floor> floorMap;
  ArrayList<GameObject> wallMap;
  Hero hero;
  GameObject wall;
  Boss boss;
  Skeleton skeleton;
  int bossX, bossY;

  public Area() {
    testBoxX = 0;
    testBoxY = 0;
    bossX = 0;
    bossY = 0;
    size = 72;
    filename = "assets/hero-down.png";
    wallMap = new ArrayList<>();
    addWall();
    floorMap = new ArrayList<>();
    addFloor();
    addBoss();


  setPreferredSize(new Dimension(720, 720));

  setVisible(true);

}

public void addBoss() {
  boss = new Boss("assets/boss.png", randomNumber()*size, randomNumber()*size);
  boolean isItFree = false;
  while (!isItFree) {
    for (int i = 0; i < wallMap.size(); i++) {
      wall = wallMap.get(i);
      if (wall.getPosX() == boss.getPosX() && wall.getPosY() == boss.getPosY()) {
        boss.setPosX(randomNumber()*size);
        boss.setPosY(randomNumber()*size);
      } else {
        isItFree = true;
      }
    }
  }
  wallMap.add(boss);
}



  public void addWall() {
    for (int i = 1; i < 10; i += 2) {
      for (int j = 0; j < 10; j++) {
        if (j % 3 == 0) {

        } else {
          Wall wall = new Wall(i * size, j * size);
          wallMap.add(wall);
        }
      }
    }
  }


  public void addFloor() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Floor floor = new Floor(i * size, j * size);
        floorMap.add(floor);
      }
    }
  }

  public int randomNumber() {
    int rNumber = (int) ((Math.random() * 9) + 1);
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
    boss.draw(graphics);
    skeleton = new Skeleton("assets/skeleton.png", boss.getPosX()+72, boss.getPosY()+72);
    skeleton.draw(graphics);

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
        if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY() - 72) {
          canIgoThere = false;
        }
      }
      if (testBoxY > 0 && canIgoThere) {
        testBoxY -= size;
        filename = "assets/hero-up.png";
      } else {
        filename = "assets/hero-up.png";
      }
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY() + 72) {
          canIgoThere = false;
        }
      }
      if (testBoxY < size * 9 && canIgoThere) {
        testBoxY += size;
        filename = "assets/hero-down.png";
      } else {
        filename = "assets/hero-down.png";
      }
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() - 72 && wall.getPosY() == hero.getPosY()) {
          canIgoThere = false;
        }
      }
      if (testBoxX > 0 && canIgoThere) {
        testBoxX -= size;
        filename = "assets/hero-left.png";
      } else {
        filename = "assets/hero-left.png";
      }
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() + 72 && wall.getPosY() == hero.getPosY()) {
          canIgoThere = false;
        }
      }
      if (testBoxX < size * 9 && canIgoThere) {
        testBoxX += size;
        filename = "assets/hero-right.png";
      } else {
        filename = "assets/hero-right.png";
      }
    }
    repaint();
  }
}
