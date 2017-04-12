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
  ArrayList<Floor> floorMap;
  ArrayList<GameObject> wallMap;
  ArrayList<Monster> monsterMap;
  ArrayList<Hero> heroMap;
  Hero hero;
  GameObject wall;
  Boss boss;
  Skeleton skeleton;
  Monster monster;

  public Area() {
    testBoxX = 0;
    testBoxY = 0;
    wallMap = new ArrayList<>();
    addWall();
    floorMap = new ArrayList<>();
    addFloor();
    heroMap = new ArrayList<>();
    addHero();
    monsterMap = new ArrayList<>();
    addBoss();
    addSkeleton();
    addSkeleton();
    addSkeleton();

    setPreferredSize(new Dimension(720, 790));
    setVisible(true);
  }

  public void addHero() {
    hero = new Hero(ImageLoader.getInstance().HERO_DOWN, testBoxX, testBoxY);
    heroMap.add(hero);
  }

  private void drawHero(Graphics graphics) {
    for (int i = 0; i < heroMap.size(); i++) {
      GameObject hero = heroMap.get(i);
      hero.draw(graphics);
    }
  }

  public void addBoss() {
    int x = randomNumber() * SIZE;
    int y = randomNumber() * SIZE;
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        int wallx = wall.getPosX();
        int wally = wall.getPosY();
        if (wallx == x && wally == y) {
          x = (randomNumber() * SIZE);
          y = (randomNumber() * SIZE);
        } else {
          boss = new Boss(ImageLoader.getInstance().BOSS, x, y);
          isItFree = true;
        }
      }
    }
    wallMap.add(boss);
    monsterMap.add(boss);
  }

  public void addSkeleton() {
    int x = randomNumber() * SIZE;
    int y = randomNumber() * SIZE;
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if ((wall.getPosX() == x) && (wall.getPosY() == y)) {
          x = (randomNumber() * SIZE);
          y = (randomNumber() * SIZE);
        } else {
          skeleton = new Skeleton(ImageLoader.getInstance().SKELETON, x, y);
          isItFree = true;
        }
      }
    }
    wallMap.add(skeleton);
    monsterMap.add(skeleton);
  }

  public void addWall() {
    for (int i = 1; i < 10; i += 2) {
      for (int j = 0; j < 10; j++) {
        if (j % 3 == 0) {

        } else {
          Wall wall = new Wall(ImageLoader.getInstance().WALL, i * SIZE, j * SIZE);
          wallMap.add(wall);
        }
      }
    }
  }


  public void addFloor() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Floor floor = new Floor(ImageLoader.getInstance().FLOOR, i * SIZE, j * SIZE);
        floorMap.add(floor);
      }
    }
  }

  private void drawWall(Graphics graphics) {
    for (int i = 0; i < wallMap.size(); i++) {
      GameObject wall = wallMap.get(i);
      wall.draw(graphics);
    }
  }

  public void drawFloor(Graphics graphics) {
    for (int i = 0; i < floorMap.size(); i++) {
      Floor floor = floorMap.get(i);
      floor.draw(graphics);
    }
  }

  public int randomNumber() {
    int rNumber = (int) (Math.random() * 10);
    return rNumber;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    drawFloor(graphics);
    drawWall(graphics);
    drawHero(graphics);
    Graphics2D g2d = (Graphics2D) graphics;
    isHeroDead(g2d);
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
      heroMoveUp();
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      heroMoveDown();
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      heroMoveLeft();
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      heroMoveRight();
    } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      battle();
    }
    repaint();
  }

  public void isHeroDead( Graphics2D g2d) {
    if (heroMap.size() == 0) {
      gameMessages(g2d, "You died! Game over.");
    } else {
      g2d.drawString(hero.toString(), 216, 750);
      monsterStats(g2d);
    }
  }

  public void monsterStats(Graphics2D graphics2D) {
    for (int i = 0; i < monsterMap.size(); i++) {
      monster = monsterMap.get(i);
      if (monster.getPosX() == hero.getPosX() && monster.getPosY() == hero.getPosY()) {
        graphics2D.drawString(monster.toString(), 216, 770);
      }
    }
  }

  private void gameMessages(Graphics2D graphics2D, String gameMessage) {
    graphics2D.drawString(gameMessage, 288, 760);
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


  public void heroStrikes() {
        int strikeValue = hero.getStrikeSP() + (2 * GameLogic.rollTheDice());
        if (strikeValue > monster.getDefendDP()) {
          if (monster.getCurrentHP() <= (strikeValue - monster.getDefendDP())) {
            monster.setCurrentHP(0);
            monsterMap.remove(monster);
            wallMap.remove(monster);
            int levelUp = hero.getLevel() + 1;
            hero.setLevel(levelUp);
          }
          int decreasedHP = monster.getCurrentHP() - (strikeValue - monster.getDefendDP());
          monster.setCurrentHP(decreasedHP);
        }

      }

  private void heroMoveRight() {
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

  private void heroMoveLeft() {
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

  private void heroMoveDown() {
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
}
