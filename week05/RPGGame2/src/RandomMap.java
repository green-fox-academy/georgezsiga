import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/12/17.
 */
public class RandomMap {

  ArrayList<GameObject> finalMap;
  ArrayList<GameObject> tempList;
  ArrayList<GameObject> tempList2;


  public RandomMap() {
    createRandomMap();
  }

  public void addRandomTile(int i, int j) {
    int randNum = GameLogic.randomTiles();
    if (randNum == 0) {
      Floor floor = new Floor(ImageLoader.getInstance().FLOOR, i, j);
      finalMap.add(floor);
    } else {
      Wall wall = new Wall(ImageLoader.getInstance().WALL, i, j);
      finalMap.add(wall);
    }
  }

  public void createRandomMap() {
    finalMap = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (i == 0 && j == 0) {
          Floor floor = new Floor(ImageLoader.getInstance().FLOOR, i, j);
          finalMap.add(floor);
        } else if (i == 0 && j > 0) {
          addRandomTile(i, j);
        } else if (j == 0 && i > 0) {
          int a = (i - 1) * 10;
          int b = ((i - 1) * 10) + 1;
          if (finalMap.get(a) instanceof Floor && finalMap.get(b) instanceof Floor) {
            addRandomTile(i, j);
          } else {
            Floor floor = new Floor(ImageLoader.getInstance().FLOOR, i, j);
            finalMap.add(floor);
          }
        } else if (i > 0 && i < 9 && j == 9) {
          tempList = new ArrayList<>();
          tempList2 = new ArrayList<>();
          int a = ((i - 1) * 10) + 9;
          int b = ((i - 1) * 10) + 8;
          int c = (i * 10) - 1;
          tempList.add(finalMap.get(a));
          tempList.add(finalMap.get(b));
          tempList.add(finalMap.get(c));
          for (int k = 0; k < tempList.size(); k++) {
            if (tempList.get(k) instanceof Wall) {
              tempList2.add(tempList.get(k));
            }
          }
          int size = tempList2.size();
          if (size < 1) {
            addRandomTile(i, j);
          } else {
            Floor floor = new Floor(ImageLoader.getInstance().FLOOR, i, j);
            finalMap.add(floor);
          }
        } else if (i == 9 && j > 0) {
          int a = ((i - 1) * 10) + j - 1;
          int b = (i * 10) + j - 1;
          if (finalMap.get(a) instanceof Floor && finalMap.get(b) instanceof Floor) {
            addRandomTile(i, j);
          } else {
            Floor floor = new Floor(ImageLoader.getInstance().FLOOR, i, j);
            finalMap.add(floor);
          }
        } else {
          tempList = new ArrayList<>();
          tempList2 = new ArrayList<>();
          int a = ((i - 1) * 10) + j;
          int b = ((i - 1) * 10) + j + 1;
          int c = ((i - 1) * 10) + j - 1;
          int d = ((i * 10) + j) - 1;
          tempList.add(finalMap.get(a));
          tempList.add(finalMap.get(b));
          tempList.add(finalMap.get(c));
          tempList.add(finalMap.get(d));
          for (int k = 0; k < tempList.size(); k++) {
            if (tempList.get(k) instanceof Wall) {
              tempList2.add(tempList.get(k));
            }
          }
          int size = tempList2.size();
          if (size < 2) {
            addRandomTile(i, j);
          } else {
            Floor floor = new Floor(ImageLoader.getInstance().FLOOR, i, j);
            finalMap.add(floor);
          }
        }
      }
    }
  }

  public ArrayList<GameObject> getFinalMap() {
    return finalMap;
  }
}
