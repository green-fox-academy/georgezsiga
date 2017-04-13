import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * Created by georgezsiga on 4/10/17.
 */
public class Area extends JComponent implements KeyListener {

  int testBoxX, testBoxY, SIZE;
  GameLogic gameLogic;
  ArrayList<GameObject> finalMap, wallMap;
  ArrayList<Monster> monsterMap;
  ArrayList<Hero> heroMap;
  GameObject wall;
  Floor floor;
  Wall walls;
  Hero hero;
  Monster monster;
  Boss boss;
  Skeleton skeleton;


  public Area() {
    SIZE = GameObject.SIZE;
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

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    Graphics2D g2d = (Graphics2D) graphics;
    drawRandomMap(graphics);
    drawHero(graphics);
    drawMonsters(graphics);
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
    for (int i = 0; i < monsterMap.size() ; i++) {
      monster = monsterMap.get(i);
      monster.draw(graphics);
    }
  }

  public void levelUpArea() {
    hero.setPosX(0);
    hero.setPosY(0);
    hero.heroRestoreHP();
    this.wallMap = new ArrayList<>();
    addWall();
    this.monsterMap = new ArrayList<>();
    int newMapLevel = monster.getMapLevel() + 1;
    addMonsters(newMapLevel);
  }

  public void addMonsters(int newMapLevel) {
    addBoss(newMapLevel);
    addSkeleton(true, newMapLevel);
    for (int i = 0; i < GameLogic.randomMonsters(); i++) {
      addSkeleton(false, newMapLevel);
    }
  }

  public void addHero() {
    hero = new Hero(ImageLoader.getInstance().HERO_DOWN, testBoxX, testBoxY);
    heroMap.add(hero);
  }

  public void addBoss(int newMaplevel) {
    int x = GameLogic.randomNumber() * SIZE;
    int y = GameLogic.randomNumber() * SIZE;
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        int wallx = wall.getPosX();
        int wally = wall.getPosY();
        if (wallx == x && wally == y) {
          x = (GameLogic.randomNumber() * SIZE);
          y = (GameLogic.randomNumber() * SIZE);
        } else {
          boss = new Boss(ImageLoader.getInstance().BOSS, x, y, newMaplevel);
          isItFree = true;
        }
      }
    }
    wallMap.add(boss);
    monsterMap.add(boss);
  }

  public void addSkeleton(boolean gotKey, int newMapLevel) {
    int x = GameLogic.randomNumber() * SIZE;
    int y = GameLogic.randomNumber() * SIZE;
    boolean isItFree = false;
    while (!isItFree && (x > 0 || y > 0)) {
      for (int i = 0; i < wallMap.size(); i++) {
        wall = wallMap.get(i);
        if ((wall.getPosX() == x) && (wall.getPosY() == y)) {
          x = (GameLogic.randomNumber() * SIZE);
          y = (GameLogic.randomNumber() * SIZE);
        } else {
          skeleton = new Skeleton(ImageLoader.getInstance().SKELETON, x, y, gotKey, newMapLevel);
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
    timer.start();
  }

  javax.swing.Timer timer = new javax.swing.Timer(1500, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      for (int i = 0; i < monsterMap.size(); i++) {
        monster = monsterMap.get(i);
        moveMonster();
      }
      repaint();
    }
  });


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
        if (monster.isGotKey() && !monsterMap.contains(boss)) {
          hero.heroLevelUp();
          levelUpArea();
        } else if (monster == boss && !monsterMap.contains(skeleton)) {
          hero.heroLevelUp();
          levelUpArea();
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

  private void moveMonster() {
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
