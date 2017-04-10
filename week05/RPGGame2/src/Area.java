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
  ArrayList<Wall> wallMap;
  Hero hero;
  Wall wall;

  public Area() {
    testBoxX = 0;
    testBoxY = 0;
    size = 72;
    filename = "assets/hero-down.png";
    wallMap = new ArrayList<>();
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Floor floor = new Floor( i * size, j * size);
//        tileMap.add(floor);
        floor.draw(graphics);
      }
    }

    for (int i = 1; i < 10; i+=2) {
      for (int j = 0; j < 10; j++) {
        if (j % 3 == 0) {

        } else {
          Wall wall = new Wall(i * size, j * size);
          wallMap.add(wall);
          wall.draw(graphics);
        }
      }
    }
    hero = new Hero(filename, testBoxX, testBoxY);
    hero.draw(graphics);

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
      for (int i = 0; i < wallMap.size() ; i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY()) {
          canIgoThere = false;
        }
      }
      if (testBoxY > 0 && canIgoThere) {
        testBoxY -= size;
        filename = "assets/hero-up.png";
      } else {
        filename = "assets/hero-up.png";
      }
    } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
      for (int i = 0; i < wallMap.size() ; i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY()) {
          canIgoThere = false;
        }
      }
      if (testBoxY < size*9) {
      testBoxY += size;
      filename = "assets/hero-down.png";
    } else {
      filename = "assets/hero-down.png";
    }
    } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
      for (int i = 0; i < wallMap.size() ; i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY()) {
          canIgoThere = false;
        }
      }
      if (testBoxX > 0) {
      testBoxX -= size;
      filename = "assets/hero-left.png";
  } else {
    filename = "assets/hero-left.png";
  }
    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
      for (int i = 0; i < wallMap.size() ; i++) {
        wall = wallMap.get(i);
        if (wall.getPosX() == hero.getPosX() && wall.getPosY() == hero.getPosY()) {
          canIgoThere = false;
        }
      }
      if (testBoxX < size*9) {
      testBoxX += size;
      filename = "assets/hero-right.png";
    } else {
    filename = "assets/hero-right.png";
    }
    }
    repaint();
  }


}
