import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/12/17.
 */
public class RandomMap {
  ArrayList<Floor> floorMap;
  ArrayList<GameObject> wallMap;

  public RandomMap() {
    floorMap = new ArrayList<>();
    addFloor();
    wallMap = new ArrayList<>();
    addWall();
  }

  public void addWall() {
    for (int i = 1; i < 10; i += 2) {
      for (int j = 0; j < 10; j++) {
        int randNum = GameLogic.randomTiles();
        if (randNum == 0) {

        } else {
          Wall wall = new Wall(ImageLoader.getInstance().WALL, i * GameObject.SIZE, j * GameObject.SIZE);
          wallMap.add(wall);
        }
      }
    }
  }


  public void addFloor() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Floor floor = new Floor(ImageLoader.getInstance().FLOOR, i * GameObject.SIZE, j * GameObject.SIZE);
        floorMap.add(floor);
      }
    }
  }

}
