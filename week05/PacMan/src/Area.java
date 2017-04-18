import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * Created by georgezsiga on 4/14/17.
 */
public class Area extends JComponent implements KeyListener {

  GameLogic gameLogic;
  ArrayList<GameObject> finalMap, wallMap;
  ArrayList<Hero> heroMap;
  ArrayList<Monster> monsterMap;
  GameObject wall, floor;
  Hero hero;
  Monster monster;
  Boss boss;
  Skeleton skeleton;

  public Area() {
    RandomMap randomMap = new RandomMap();
    finalMap = new ArrayList<>();
    finalMap = randomMap.getFinalMap();
    wallMap = new ArrayList<>();
    addWall();
    heroMap = new ArrayList<>();
    addHero();
    monsterMap = new ArrayList<>();
    addMonsters(1);
    setPreferredSize(new Dimension(800, 800));
    setVisible(true);
    gameLogic = new GameLogic(this);
  }

  public void levelUpArea() {
    RandomMap randomMap = new RandomMap();
    finalMap = new ArrayList<>();
    finalMap = randomMap.getFinalMap();
    wallMap = new ArrayList<>();
    addWall();
    heroMap = new ArrayList<>();
    addHero();
    monsterMap = new ArrayList<>();
    addMonsters(1);
    gameLogic = new GameLogic(this);
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

  public void addWall() {
    for (int i = 1; i < finalMap.size(); i++) {
      if (finalMap.get(i) instanceof Wall) {
        wallMap.add(finalMap.get(i));
      } else {

      }
    }
  }

  public void addMonsters(int newMapLevel) {
    addBoss(newMapLevel);
    addSkeleton(true, newMapLevel);
    for (int i = 0; i < GameLogic.randomMonsters(); i++) {
      addSkeleton(false, newMapLevel);
    }
    wallMap.remove(hero);
  }

  public void addHero() {
    int x = GameLogic.randomNumber();
    int y = GameLogic.randomNumber();
    boolean isItFree = false;
    while (!isItFree) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        int wallx = wall.getPosX();
        int wally = wall.getPosY();
        if (wallx == x && wally == y) {
          x = GameLogic.randomNumber();
          y = GameLogic.randomNumber();
        } else {
          hero = new Hero(ImageLoader.getInstance().PACMAN, x, y);
          isItFree = true;
        }
      }
    }
    wallMap.add(hero);
    heroMap.add(hero);
    for (int i = 0; i < finalMap.size(); i++) {
      if (finalMap.get(i).getPosX() == hero.getPosX() && finalMap.get(i).getPosY() == hero
          .getPosY()) {
        finalMap.get(i).setImage(ImageLoader.getInstance().NODOT);
      }
    }
  }

  public void addBoss(int newMaplevel) {
    int x = GameLogic.randomNumber();
    int y = GameLogic.randomNumber();
    boolean isItFree = false;
    while (!isItFree) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        int wallx = wall.getPosX();
        int wally = wall.getPosY();
        if (wallx == x && wally == y) {
          x = GameLogic.randomNumber();
          y = GameLogic.randomNumber();
        } else {
          boss = new Boss(ImageLoader.getInstance().BLACK, x, y, newMaplevel);
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
    while (!isItFree) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if ((wall.getPosX() == x) && (wall.getPosY() == y)) {
          x = GameLogic.randomNumber();
          y = GameLogic.randomNumber();
        } else {
          skeleton = new Skeleton(ImageLoader.getInstance().RED, x, y, gotKey, newMapLevel);
          isItFree = true;
        }
      }
    }
    wallMap.add(skeleton);
    monsterMap.add(skeleton);
  }

  public void areTheyOnTheSameTile() {
    for (int i = 0; i < monsterMap.size(); i++) {
      if (monsterMap.get(i).getPosX() == hero.getPosX() && monsterMap.get(i).getPosY() == hero
          .getPosY()) {
        hero = heroMap.get(0);
        heroMap.remove(hero);
      }
    }
  }

  public void replaceFloor() {
    for (int i = 0; i < finalMap.size(); i++) {
      if (finalMap.get(i).getPosX() == hero.getPosX() && finalMap.get(i).getPosY() == hero
          .getPosY()) {
        finalMap.get(i).setImage(ImageLoader.getInstance().NODOT);
        finalMap.get(i).setDot(false);
      }
    }
  }

  public void areThereAnyMoreDots() {
    int counter = 0;
    for (int i = 0; i < finalMap.size(); i++) {
      if (finalMap.get(i) instanceof Floor) {
        floor = finalMap.get(i);
        if (floor.isDot) {
          counter ++;
        }
      }
    }
    if (counter == 0) {
      levelUpArea();
    }
  }

  @Override
  public void keyTyped(KeyEvent KeyEvent) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      gameLogic.heroMoveUp();
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      gameLogic.heroMoveDown();
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      gameLogic.heroMoveLeft();
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      gameLogic.heroMoveRight();
    }
    areTheyOnTheSameTile();
    replaceFloor();
    repaint();
    timer.start();
  }

  @Override
  public void keyReleased(KeyEvent KeyEvent) {

  }

  javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      gameLogic.moveMonster();
      repaint();
    }
  });

  public void isHeroDead(Graphics2D g2d) {
    if (heroMap.size() == 0) {
      gameMessages(g2d, "You died! Game over.");
    }
  }

  private void gameMessages(Graphics2D graphics2D, String gameMessage) {
    graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, 70));
    graphics2D.drawString(gameMessage, 20, 400);
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
}
